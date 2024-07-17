read = input()

def is_palindrome(read):
    check = ''


    for i in range(len(read) - 1, -1, -1):
        check += read[i]

    if check == read:
        return 1
    else:
        return 0

print(is_palindrome(read))