# PA1 – TCP Client/Server Socket Programming (Java)

This project implements a simple TCP client/server system in Java using sockets.

The server validates alphabet-only strings received from the client, converts valid strings to uppercase, and sends the result back.  
The client measures round-trip time (RTT) for each request and reports statistics.

This project was created for CIS4930 – Internet Storage Systems.

---

## Project Files

- Server.java – TCP server implementation
- Client.java – TCP client implementation

---

## Requirements

- Java JDK 21 or newer
- Two computers connected to the same network (recommended for demonstration)

---

## Compilation

Compile both files:

javac Server.java
javac Client.java

This will generate Server.class & Client.class

Now on Computer A (Server)

Run:
    ipconfig getifaddr en0 - to get target ip
    java Server <last_4_digits_of_UFID>

On Computer B (Client)

Run:
    java Client <server_ip> <last_4_digits_of_UFID>

Send alphabetical inputs as client and enure they reach the host server

To close the connection - As client type "bye"
Once connection is severed host will respond with "disconnected"

after the connection ends round trip statistics will be displayed on the client side.