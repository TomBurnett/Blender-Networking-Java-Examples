import socket
import sys
import bge.logic as G
import pickle

# Bind the socket to the port
server_address = ('localhost', 10000)
listen_address = ('localhost', 10001)

def init():

    # Create a UDP socket
    G.listener = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    G.sender = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

    print ('starting up on %s port %s' % server_address)

    G.listener.setblocking(0)
    G.sender.setblocking(0)

    G.listener.bind(listen_address)


def listen():

    #own = G.getCurrentController().owner

    # bge.types.SCA_PythonController
    cont = G.getCurrentController()
    obj = cont.owner

# bge.types.KX_GameObject

    try:

        data = G.listener.recv(10001)
        #print(data)
        if data:
            #newData = data.strip("<>")
            data = data.decode();
            data = data.replace(",", "")
            data = data.strip("<>")
            data = data[8:-1]

            data = data.split()
            print(data)
            #for coord in coords:
            #    print(coord)

            #vec = mathutils.Vector((float(data[0]), float(data[1]), float(data[2])))

            obj.worldPosition.x = float(data[0])
            obj.worldPosition.y = float(data[1])
            obj.worldPosition.z = float(data[2])

            #own.setPosition(16, 16, 16)

    except:
        #No message to receive
        pass

def send():

    # get the object that is attached to this script
    own = G.getCurrentController().owner

    try:

        string = str(own.worldPosition)
        sent = G.sender.sendto(string.encode(), server_address);

        #print ( "sent %s bytes to %s" % (data, server_address) )

        #print ( string )
        '''
        if sent:

            try:

                data = G.listener.recvfrom(4096)

                print ( 'received %s bytes' % (data) )
            except:
                print ("Sending Failed")
        '''
    except:
        #No message to receive, do nothing
        pass
        #print ("Receive failed")
