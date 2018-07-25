class main:
	n = int(input())
	mod = 1000000000
	s = [[],[],[],[],[],[],[],[],[],[]] 
	for i in range(0,10):
			s[1].append(1)
	for i in range(1,n+1):
			s[i].append(0)
			for k in range(0,10):
				print(s)
				if(k - 1 >= 0):
					s[i][k] += s[i-1][k-1]
				if(k + 1 <= 9):
					s[i][k] += s[i-1][k+1]
				s[i][k] %= mod 
	print(s)

if __name__ == "__main__":
	main()
