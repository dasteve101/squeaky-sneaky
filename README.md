![alt tag](images/logo.jpg)

A peer to peer crypto call and message app

Design
======

Each device will have the Squeaky Sneaky app

On install generate a RSA 4096 key

To add to a contact scan a QR Code of someones public key

To call, find their IP address through a SMS then establish connection with DH/RSA

Call encrypted with AES, counter mode.

Implement perfect forward secrecy by re-establishing the key at a random interval of at most 5 mins
