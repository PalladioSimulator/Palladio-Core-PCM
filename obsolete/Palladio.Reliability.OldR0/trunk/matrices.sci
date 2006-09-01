P=[
0.3,0.4,0,0,0.3,0,0;
0.4,0.1,0.2,0.3,0,0,0;
0,0,0.9,0,0,0,0.1;
0,0,0,0,0.1,0,0.9;
0,0,0,0.5,0,0.5,0;
0,0,0,0,0,0.1,0.9;
0,0,0,0,0,0,0];

[m,n] = size(P);
I=eye(m,n);
R= (I-P)^(-1);

for i=1:n
	for j=1:n
		if (i==j)
			F(i,j) = 1 - 1/R(i,j);
		else
			F(i,j) = R(i,j)/R(j,j);
		end
		nF(i,j) = 1 - F(i,j);
	end
end

Ps = [
0,1.0,0,0,0,0;
0,0.3,0.4,0,0.3,0;
0,0.4,0.1,0.3,0,0.2;
0,0,0,0,0.1,0.9;
0,0,0,0,0,0;
0,0,0,0,0,0]

[m,n] = size(Ps);
Is = eye(m,n);
Rs = (Is - Ps)^(-1);

for i=1:n
	for j=1:n;
		if (i==j)
			Fs(i,j) = 1 - 1/Rs(i,j);
		else
			Fs(i,j) = Rs(i,j)/Rs(j,j);
		end
		nFs(i,j) = 1 - Fs(i,j);
	end
end

for i=1:n
	h(i)= Rs(1,i) * Fs(i,5);
	hs(i)=h(i)/Fs(1,5);
end

Pf = [
0,0.5,0.5,0,0;
0,0,0,0.9,0.1;
0,0,0.1,0.9,0;
0,0,0,0,0;
0,0,0,0,0]

[m,n] = size(Pf);
If = eye(m,n);
Rf = (If - Pf)^(-1);

for i=1:n
	for j=1:n;
		if (i==j)
			Ff(i,j) = 1 - 1/Rf(i,j);
		else
			Ff(i,j) = Rf(i,j)/Rf(j,j);
		end
		nFf(i,j) = 1 - Ff(i,j);
	end
end

