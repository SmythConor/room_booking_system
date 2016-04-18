BIN=/home/conor/work/college/year4/room_booking_system/bin

if [ ! -f "$BIN" ]; then
	cd $BIN

	while getopts ":p" opt; do
		case $opt in
			p)
				java com.roombooking.publisher.RoomBookingServicePublisher
				;;
			c)
				java com.roombooking.client.RoomBookingClient
				;;
			\?)
				echo "Invalid option -$OPTARG" >&2
				echo "To publish use option -p"
				echo "To run client use option -c"
				echo "Exiting..."
				exit 1
				;;
		esac
	done
fi
