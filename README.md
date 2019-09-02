[![Build Status](https://travis-ci.org/his-eg/macker.svg)](https://travis-ci.org/his-eg/macker)

[Documentation and examples](http://innig.net/macker/guide/)

To create new version of maven artifact do this:

Checkout `mvn-repo` branch into some folder
Run command:
``````
mvn clean package deploy:deploy-file \
    -DgroupId=de.andrena.tools.macker \
    -DartifactId=macker \
    -Dversion=1.0.6-CUSTOM \
    -Dfile=target/macker-1.0.6-CUSTOM.jar \
    -Dsources=target/macker-1.0.6-CUSTOM-sources.jar \
    -Djavadoc=target/macker-1.0.6-CUSTOM-javadoc.jar \
    -DpomFile=pom.xml \
    -Durl=file://path-to-mvn-repo-folder
``````

Change version numbers according to the new version.
Specify path to the folder with `mvn-repo` branch. It must be full path in URL format starting with `file://` protocol.
