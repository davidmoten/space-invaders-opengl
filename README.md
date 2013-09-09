space-invaders-opengl
=====================

Demonstrates how to use java for hardware accelerated graphics using the OpenGL standard via the [LWJGL](http://www.lwjgl.org/) java wrapper.

The source code originated [here](http://www.lwjgl.org/wiki/index.php?title=Space_Invaders_Example_Game) and was playable (via webstart) and viewable but not convenient for import into an IDE.

<img src="https://raw.github.com/davidmoten/space-invaders-opengl/master/docs/screensnap.png"/>

Getting started
----------------------

To run as an application from the command line:

    git clone https://github.com/davidmoten/space-invaders-opengl.git
    cd space-invaders-opengl
    mvn test exec:java
    
To run in Eclipse as an applet:

* Import the project into Eclipse using <i>File - Import - Maven - Existing projects</i>
* Then in Package Explorer select the <code>space-invaders-opengl</code> project, click right mouse button and <i>Run As - Applet</i>.

