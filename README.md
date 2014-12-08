DESMessenger
============

A simple messenger app where users send 3DES-encrypted text to eachother.

The program is configured to send and receive on a socket over the localhost, although
it can be modified to work over the internet with a custom IP address and port with a few
simple changes to ClientMain.java and ServerMain.java

Instructions for localhost:

1. Compile all source .java files

2. Run ServerMain.java

3. In another terminal, run ClientMain.java

4. Two Java GUIs will open. Each window has the ability to accept input and sent it across
   the socket to the other window. The message is encrypted with Triple DES before being sent,
   and decrypted after being received
