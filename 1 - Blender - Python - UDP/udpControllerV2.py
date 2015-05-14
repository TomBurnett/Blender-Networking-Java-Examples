import socket
import sys
import bge.logic as G

# Listen for localhost packets on port 10000
listen_address = ('localhost', 10000)
send_address = ('localhost', 10001)

listen_port = 10000
send_port = 10001

message = 'Hello Java, From Blender.'

def init():

	# Create a UDP (Datagram) socket for sending & recieving
	G.listener = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
	G.sender = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

	# Bind the socket to a specified port
	G.listener.bind(listen_address)

	print ('starting up on %s port %s' % listen_address)

	G.listener.setblocking(0)
	G.sender.setblocking(0)
	

def listen():

	try:

		data = G.listener.recv(listen_port)

		if data: # only send a message back if one is recieved

			print ('received %s bytes from %s' % (len(data), listen_port))
			print ( data )

			sent = G.sender.sendto(message.encode(), send_address)

			print("sent")

	except:
		#No message to receive
		pass
