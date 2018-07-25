class main:
	a = int(input())
	s = [0,0]
	for i in range(2,a+1):
		k = i
		if(k % 3 == 0):
			s.append(min(s[int(k/3)] + 1,s[int(k-1)] + 1))
		elif(k % 2 == 0):
			s.append(min(s[int(k/2)] + 1,s[int(k-1)] + 1))
		elif(k % 3 != 0)  and (k % 2 != 0):
			s.append(s[int(k-1)] + 1)

	print(s[a])
		
	

if __name__ == "__main__":
	main()
