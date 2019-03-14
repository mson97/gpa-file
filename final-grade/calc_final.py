n = int(input("Enter the number of grading categories for the class\n"))

grade = 0
counter = 1
total_weight = 0

while n > 0:
	weight = int(input("Enter the weight of item %d\n" % counter))
	total_weight += weight
	if total_weight > 100:
		print("The total weight of the assignments exceeds 100")
		exit()
	
	received = int(input("Enter the grade you received (out of 100) on item %d\n" % counter))
	if received > 100 or received < 0:
		print("You have entered in an invalid grade")
		exit()
	
	grade += weight * .01 * received
	n -= 1
	counter += 1

choice = 'c'

choice = raw_input("Would you like to calculate what you need on the final?\n(yes or no)\n")

if choice == 'yes':
	final_weight = int(input("How much is the final worth?\n"))
	desired_grade = int(input("What grade do you want in the class? (out of 100)\n"))
	final_grade = desired_grade - grade
	final_grade //= (final_weight * .01)
	print("You need a %d on the final to get a %d in the class" % (final_grade, desired_grade))
else:
	print("You have a %d in the class" % grade)