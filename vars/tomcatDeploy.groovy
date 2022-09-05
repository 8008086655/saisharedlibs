def call(ip, user, credID){
  sshagent([credID]) {
 // copy war
 sh 'scp -o StrictHostKeyChecking=no target/*.war ${user}@${ip}:/opt/tomcat9/webapps' 
 // stop tomcat
 sh 'ssh -o StrictHostKeyChecking=no ${user}@172.31.40.103 /opt/tomcat9/bin/shutdown.sh'
 // start tomcat
 sh 'ssh ${user}@172.31.40.103 /opt/tomcat9/bin/startup.sh'
  }
}
