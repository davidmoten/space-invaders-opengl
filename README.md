space-invaders-opengl
=====================

Demonstrates how to use java for hardware accelerated graphics using the [OpenGL](http://www.opengl.org/) standard via the [LWJGL](http://www.lwjgl.org/) java wrapper.

Status: *alpha*

The source code originated [here](http://www.lwjgl.org/wiki/index.php?title=Space_Invaders_Example_Game) but was not in a useful form to experiment with so this project was created.

<img src="https://raw.github.com/davidmoten/space-invaders-opengl/master/src/docs/screensnap.png" height="500"/>

Getting started
----------------------

To run from the command line:

    git clone https://github.com/davidmoten/space-invaders-opengl.git
    cd space-invaders-opengl
    mvn test exec:java
    
To start full screen (texture mapping is cool!):

    mvn test exec:java -DfullScreen=true
    
To run in Eclipse as an applet:

* Import the project into Eclipse using <i>File - Import - Maven - Existing projects</i>
* Then in Package Explorer select the <code>space-invaders-opengl</code> project, click right mouse button and <i>Run As - Applet</i>.

