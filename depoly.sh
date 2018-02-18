id=$(ps -ef | awk '/[j]etty/{print $2}')
if [ -n "$id" ]; then
	echo "Killing jetty with PID $id"
	sudo kill "$id"
fi

id=$(ps -ef | awk '/[t]omcat/{print $2}')
if [ -z "$id" ]; then
	echo "Tomcat not started. Starting it now:"
	$CATALINA_HOME/bin/startup.sh
fi

mvn clean package && cp -f target/bank-asgmt2.war /usr/share/tomcat8/webapps/
