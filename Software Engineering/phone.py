
def menu():
    print('1. Print All Contacts')
    print('2. Add a Contact / Add a number to a Contact')
    print('3. Remove a Contact')
    print('4. Lookup a Contact')
    print('5. Update a Contact')
    print('6. Quit')
    print()

numbers = {}

menu_choice = 0

menu()

while menu_choice != 6:

    menu_choice = int(input("Select Option (1 - 6): "))

    if menu_choice == 1:
        print("Contacts :")
        print('----------------------')
        for x in sorted(numbers.keys()):
            print("Name    : ", x)
            print('Numbers :')
            for i in numbers[x]:
                print('        : ',i)
            print('----------------------')
        print()

    elif menu_choice == 2:
        print("Add Contact")
        name =  input("Name   : ")
        phone = input("Number : ")
        numbers.setdefault(name,[])
        numbers[name].append(phone)
        print()

    elif menu_choice == 3:
        print("Remove Contact")
        name = input("Name: ")
        if name in numbers.keys():
            del numbers[name]
        else:
            print(name, "was not found")
        print()

    elif menu_choice == 4:
        print("Lookup a Contact")
        name = input("Name: ")
        if name in sorted(numbers.keys()):
            print('Numbers :')
            for i in numbers[name]:
                print(i)
            print('----------------------')
        else:
            print(name, "was not found")
        print()

    elif menu_choice == 5:
        print("Contact whose number to be updated")
        name = input("Name: ")
        if name in sorted(numbers.keys()):
            del numbers[name]
            phone = input("Updated Number : ")
            numbers.setdefault(name,[])
            numbers[name].append(phone)
        else:
            print(name, "was not found")
        print()

    if menu_choice != 6:
        menu()
