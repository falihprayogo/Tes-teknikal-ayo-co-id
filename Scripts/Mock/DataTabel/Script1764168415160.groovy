println("=== MOCK DATA LOADED ===")

// BOOKING LIST
List bookingList = [
	[
		id: 1001,
		booking_id: "BK/000001",
		venue_id: 15,
		user_id: 12,
		date: "2022-12-10",
		start_time: "09:00",
		end_time: "11:00",
		price: 1200000
	],
	[
		id: 1005,
		booking_id: "BK/000005",
		venue_id: 15,
		user_id: 12,
		date: "2022-12-10",
		start_time: "09:00",
		end_time: "11:00",
		price: 1000000
	]
]

// SCHEDULE LIST
List scheduleList = [
	[id: 11, venue_id: 15, date: "2022-12-10", start_time: "07:00", end_time: "09:00", price: 800000],
	[id: 12, venue_id: 15, date: "2022-12-10", start_time: "09:00", end_time: "11:00", price: 1000000],
	[id: 13, venue_id: 15, date: "2022-12-10", start_time: "11:00", end_time: "13:00", price: 1200000]
]

return [bookingList, scheduleList]
