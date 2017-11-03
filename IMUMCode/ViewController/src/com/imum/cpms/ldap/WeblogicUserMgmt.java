package com.imum.cpms.ldap;


import com.imum.cpms.util.PropertiesBeanUtils;

import java.io.Serializable;
import java.io.IOException;
import java.util.Hashtable;
import javax.management.Descriptor;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.modelmbean.ModelMBeanInfo;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import javax.naming.Context;

public class WeblogicUserMgmt implements Serializable {
    private static final String MBEAN_INTERFACE = "weblogic.security.providers.authentication.DefaultAuthenticatorMBean";
    private MBeanServerConnection connection;
    private JMXConnector connector;
    private ObjectName providerON;
    
    
    public boolean IsUserExists(String username) throws Exception {
        
      return  (Boolean)
        connection.invoke(providerON, "userExists",
                          new Object[] { username },
                          new String[] { "java.lang.String" });
    }
    
    public void createUser(String username, String password,
                           String description) throws Exception {
        connection.invoke(providerON, "createUser",
                          new Object[] { username, password, description },
                          new String[] { "java.lang.String",
                                         "java.lang.String",
                                         "java.lang.String" });
    }
    
    public void createGroup(String groupName, String description) throws Exception {
        connection.invoke(providerON, "createGroup",
                          new Object[] { groupName, description },
                          new String[] { "java.lang.String",
                                         "java.lang.String" });
    }
    
    public void addMemberToGroup(String groupName, String username)throws Exception{
        connection.invoke(providerON, "addMemberToGroup",
                          new Object[] { groupName, username },
                          new String[] { "java.lang.String", "java.lang.String" });
    }

    public void changeUserPassword(String username, String oldPassword,
                                   String newPassword) throws Exception {
        connection.invoke(providerON, "changeUserPassword",
                          new Object[] { username, oldPassword, newPassword },
                          new String[] { "java.lang.String",
                                         "java.lang.String",
                                         "java.lang.String" });
    }
    
    public boolean isMember(String parentGroupName, String memberUserOrGroupName, boolean recursive)throws Exception{
        return (Boolean) connection.invoke(providerON, "isMember",
                          new Object[] { parentGroupName, memberUserOrGroupName, recursive },
                          new String []{"java.lang.String", "java.lang.String", "java.lang.Boolean"});
    }
    
    private ObjectName getAuthenticationProviderObjectName(String type)throws Exception{
       
            ObjectName defaultRealm = getDefaultRealm();
            ObjectName[] atnProviders =
                (ObjectName[])connection.getAttribute(defaultRealm,
                                                      "AuthenticationProviders");
            ObjectName MBTservice =
                new ObjectName("com.bea:Name=MBeanTypeService,Type=weblogic.management.mbeanservers.MBeanTypeService");
            for (int p = 0; atnProviders != null && p < atnProviders.length;
                 p++) {
                ObjectName provider = atnProviders[p];
                ModelMBeanInfo info =
                    (ModelMBeanInfo)connection.getMBeanInfo(provider);
                Descriptor desc = info.getMBeanDescriptor();
                String className =
                    (String)desc.getFieldValue("interfaceClassName");
                String[] mba =
                    (String[])connection.invoke(MBTservice, "getSubtypes",
                                                new Object[] { type },
                                                new String[] { "java.lang.String" });
                for (int i = 0; i < mba.length; i++) {
                    if (mba[i].equals(className)) {
                        return provider;
                    }
                }
            }
            return null;
    }
    private ObjectName getDefaultRealm() throws Exception {
        ObjectName service =
            new ObjectName("com.bea:Name=DomainRuntimeService,Type=weblogic.management.mbeanservers.domainruntime.DomainRuntimeServiceMBean");
        ObjectName domainMBean =
            (ObjectName)connection.getAttribute(service, "DomainConfiguration");
        ObjectName securityConfiguration =
            (ObjectName)connection.getAttribute(domainMBean,
                                                "SecurityConfiguration");
        ObjectName defaultRealm =
            (ObjectName)connection.getAttribute(securityConfiguration,
                                                "DefaultRealm");
        return defaultRealm;
    }
    public void connect(String hostType){
        
        String hostname = PropertiesBeanUtils.getValue("hostname") ;//hostType; //.equalsIgnoreCase("EXTERNAL") ? PropertiesBeanUtils.getValue("ext_hostname") : PropertiesBeanUtils.getValue("default_hostname") ;
        String username =PropertiesBeanUtils.getValue("username");
        String password = PropertiesBeanUtils.getValue("password");
        int port = Integer.valueOf(PropertiesBeanUtils.getValue("port"));
        connect(hostname, username, password, port);
    }
    
    public void connect(String hostname, String username, String password, int port){
        try {       
            String protocol = "t3";
            String jndi =
                "/jndi/weblogic.management.mbeanservers.domainruntime";
            JMXServiceURL serviceURL =
                new JMXServiceURL(protocol, hostname, port, jndi);
            Hashtable env = new Hashtable();
            env.put(Context.SECURITY_PRINCIPAL, username);
            env.put(Context.SECURITY_CREDENTIALS, password);
            env.put(JMXConnectorFactory.PROTOCOL_PROVIDER_PACKAGES,
                    "weblogic.management.remote");
            env.put("jmx.remote.x.request.waiting.timeout", new Long(10000));
            connector = JMXConnectorFactory.connect(serviceURL, env);
            connection = connector.getMBeanServerConnection();
            providerON = getAuthenticationProviderObjectName(MBEAN_INTERFACE);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }
    public void close(){
        try {
            connector.close();
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
}
