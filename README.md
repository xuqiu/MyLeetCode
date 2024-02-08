
#### Normal code fence as usual
``` python
import datetime

# Get current date and time
current_datetime = datetime.datetime.now()

# Format as strings
current_time = current_datetime.strftime("%H:%M:%S")  # 24-hour format
current_date = current_datetime.strftime("%Y-%m-%d")  # Year-Month-Day format
current_datetime_str = current_datetime.strftime("%Y-%m-%d %H:%M:%S")  # Year-Month-Day Hour:Minute:Second format

# Print the results
print("Current time (24-hour format):", current_time)
print("Current date:", current_date)
print("Current date and time:", current_datetime_str)
``` [Run](https://run-test.oscollege.net/KnUK)
