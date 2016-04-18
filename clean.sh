BIN=/home/conor/work/college/year4/room_booking_system/bin
RES=/home/conor/work/college/year4/room_booking_system/src/main/resources/

rm -rf $BIN
if [ -f "$RES" ]; then
	rm $RES/*.xml
fi
