import math
def triangle():
    #print()
    a = float(input('Enter length of side a : '))
    b = float(input('Enter length of side b : '))
    c = float(input('Enter length of side c : '))

        if((a <= 0) or (b <= 0) or (c <= 0) or (a + b <= c) or (a + c <= b) or (c + b <= a) ):
        print('Triangle can not be formed, check your inputs.')
        p = str(input('Do you want to test again? [Y/N] : '))
        if(p == 'y' or p == 'Y'):
            triangle()
        else:
            exit()
    text = 'This is a '
    P = math.pi
    A = math.acos((b**2 + c**2 - a**2)/(2 * b * c))
    B = math.acos((a**2 + c**2 - b**2)/(2 * a * c))
    C = math.acos((a**2 + b**2 - c**2)/(2 * a * b))
    '''
    if(A < 0):
        A += P
    if(B < 0):
        B += P
    '''
    #C = P - A - B

    A = round(A,6)
    B = round(B,6)
    C = round(C,6)
    P = round(P,6)

    if(A == P/2 or B == P/2 or C == P/2):
        text += 'right angled '

    if(a == b and b == c):
        text += 'equilateral '

    elif((a == b) or (a == c) or (b == c)):
        text += 'isosceles '

    else:
        text += 'scalene '

    text += 'triangle.'
    print(text)
    print()
    d = str(input('Do you want to test again? [Y/N] : '))
    if(d == 'y' or d == 'Y'):
        triangle()
    else:
        exit()
triangle()
