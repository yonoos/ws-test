FROM ${base.image}

LABEL PROJECT=${project.artifactId}

COPY target/PROJECT=${project.artifactId}.ear $JBOSS_HOME/standalone/deployments/${project.artifactId}.ear

EXPOSE 8080 8009 9990 7600 8888

ENTRYPOINT $JBOSS_HOME/docker-entrypoint.sh
