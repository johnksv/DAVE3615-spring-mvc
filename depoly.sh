#!/bin/bash
id=$(ps -ef | awk '/[j]etty/{print $2}')
if [ -n "$id" ]; then
	echo "Killing jetty with PID $id"
	sudo kill "$id"
fi

id=$(ps -ef | awk '/[t]omcat/{print $2}')
if [ -z "$id" ]; then
	echo "Tomcat not started. Starting it now:"	
	if [ -n "$1" ]; then
		echo "Starting in debug-mode"
		$CATALINA_HOME/bin/catalina.sh jpda start
	else
		$CATALINA_HOME/bin/startup.sh
	fi
fi


mvn clean package 
echo "Copying war to $CATALINA_HOME/webapps/"
cp -f target/bank-asgmt2.war $CATALINA_HOME/webapps/
echo "done."
