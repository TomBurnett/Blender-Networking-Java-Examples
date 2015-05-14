import socket
import sys
import bge.logic as G
import pickle

import re

# Bind the socket to the port
server_address = ('localhost', 10000)
listen_address = ('localhost', 10001)

# Create a dictionary to hold created object references
G.objects = {}


def init():

    # Create a UDP socket
    G.listener = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    G.sender = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

    print ('starting up on %s port %s' % server_address)

    G.listener.setblocking(0)
    G.sender.setblocking(0)

    G.listener.bind(listen_address)


def listen():

    cont = G.getCurrentController()
    obj = cont.owner
    scene = obj.scene # Get the scene the object is in

    try:

        data = G.listener.recv(10001)

        # Data Exists
        if data:

            # Decode data
            data = data.decode()

            # Strip leading and trailing < >
            data = data.strip("<>")

            print(data)

            # Create command format:
            # < CREATE (objectName) (uniqueObjectName) (position) >

            if "CREATE" in data:

                createCommand = re.findall("\((.*?)\)", data)

                objectName = createCommand[0]
                uniqueObjectName = createCommand[1]

                objectCoords = createCommand[2]
                objectCoords = objectCoords.split(",")
                objectCoords[1] = objectCoords[1].lstrip()

                newObject = scene.addObject("Cylinder", obj, 0)

                newObject.worldPosition.x += float(objectCoords[0])
                newObject.worldPosition.y += float(objectCoords[1])

                newObject['name'] = uniqueObjectName
                G.objects[newObject['name']] = newObject


            elif "NEWPOSITION" in data:

                createCommand = re.findall("\((.*?)\)", data)

                uniqueObjectName = createCommand[0]

                objectCoords = createCommand[1]
                objectCoords = objectCoords.split(",")
                objectCoords[1] = objectCoords[1].lstrip()

                for keys,values in G.objects.items():
                    if keys == uniqueObjectName:

                        values.worldPosition.x = float(objectCoords[0])
                        values.worldPosition.y = float(objectCoords[1])

            else:
                print("Other command")

    except:
        #No message to receive
        pass

def send():

    # get the object that is attached to this script
    own = G.getCurrentController().owner

    try:

        string = str(own.worldPosition)
        sent = G.sender.sendto(string.encode(), server_address);

    except:
        #No message to receive, do nothing
        pass
        #print ("Send failed")
