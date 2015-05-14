import socket
import sys

# Create a UDP socket
listener = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
sender = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

#server_address = ('localhost', 10000)

listen_address = ('localhost', 10001)
send_address = ('localhost', 10000)

listen_port = 10001

message = 'Hello Blender, From Java.'

# Tell socket to look for local host messages
listener.bind(listen_address)

try:

    # Send data
    print ('sending "%s"' % message)
    sent = sender.sendto(message, send_address)

    print('waiting to receive')

    # Receive response
    data = listener.recv(listen_port)
    print ('received "%s"' % data)

finally:
    print ('closing socket')
    sock.close()
