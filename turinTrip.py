def minPurchases(trip_durations, total_hours):
    min_purchases = 0
    bought = False
    # Put your code here to calculate min_purchases
    for i in reversed(sorted(trip_durations)):
        if i < total_hours:
            print("i=", i)
            bought = True
            multiple = 1
            while i*multiple < total_hours:
                multiple += 1
            min_purchases = min_purchases + multiple
            total_hours = total_hours - (i*multiple)
    # Return the result, do not change the structure
    return min_purchases if bought else -1


print(minPurchases([1, 3, 6], 15))
