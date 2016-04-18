COMPILE=/home/conor/work/college/year4/room_booking_system/src/main/java/com/roombooking/
BIN=/home/conor/work/college/year4/room_booking_system/bin

. clean.sh
if [ ! -f "$BIN" ]; then
	mkdir -p $BIN
fi

javac $COMPILE/*/*.java -d $BIN

if [ $? -eq 0 ]; then
	cd $BIN
fi
