#Build Lifecycle Basics: 

Maven is based around the central concept of a build lifecycle. What this means is that the process for building and distributing a particular artifact (project) is clearly defined.

For the person building a project, this means that it is only necessary to learn a small set of commands to build any Maven project, and the POM will ensure they get the results they desired.

There are three built-in build lifecycles: default, clean and site. The default lifecycle handles your project deployment, the clean lifecycle handles project cleaning, while the site lifecycle handles the creation of your project's site documentation.

A Build Lifecycle is Made Up of Phases
Each of these build lifecycles is defined by a different list of build phases, wherein a build phase represents a stage in the lifecycle.

For example, the default lifecycle comprises of the following phases (for a complete list of the lifecycle phases, refer to the Lifecycle Reference):

##validate - validate the project is correct and all necessary information is available
##compile - compile the source code of the project
##test - test the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed
##package - take the compiled code and package it in its distributable format, such as a JAR.
##verify - run any checks on results of integration tests to ensure quality criteria are met
##install - install the package into the local repository, for use as a dependency in other projects locally
##deploy - done in the build environment, copies the final package to the remote repository for sharing with other developers and projects.
These lifecycle phases (plus the other lifecycle phases not shown here) are executed sequentially to complete the default lifecycle. Given the lifecycle phases above, this means that when the default lifecycle is used, Maven will first validate the project, then will try to compile the sources, run those against the tests, package the binaries (e.g. jar), run integration tests against that package, verify the integration tests, install the verified package to the local repository, then deploy the installed package to a remote repository.