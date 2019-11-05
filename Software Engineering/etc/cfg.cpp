#include<bits/stdc++.h>

using namespace std;
map<int,int>m;
stack<int>s;
//int size;
const int N=2;
int complexity=1;
/*
if(condition){


}else{


}



*/

//2D Vector(as Adjacency matrix), Stack<Pair>

string& ltrim(std::string& str, const std::string& chars = "\t\n\v\f\r "){
    str.erase(0, str.find_first_not_of(chars));
    return str;
}

string& rtrim(std::string& str, const std::string& chars = "\t\n\v\f\r "){
    str.erase(str.find_last_not_of(chars) + 1);
    return str;
}

string& trim(std::string& str, const std::string& chars = "\t\n\v\f\r "){
    return ltrim(rtrim(str, chars), chars);
}

int getblocks(string fname){
	ifstream myfile;
	myfile.open(fname);
	string line;
	int count=0;
	while(getline(myfile,line)){
		count++;
		//string word=line.substr(0,line.find(' '));
		//string keyword=word.substr(0,word.substr('('));
		int start=line.find('{');
		int end=line.find('}');
		if(start<0&&end<0)
			continue;
		else if(start>=0&&end<0)
			s.push(count);
		else if(end>=0&&start<0){
			m[s.top()]=count;
			s.pop();
		}
		else{
			if(start<end)
				m[count]=count;
			else{
				m[s.top()]=count;
				s.pop();
				s.push(count);
			}
		}
	}
	return count;
}

bool stringcompare(string s1,string s2){
	for(int i=0;i<s1.length();i++){
		if(s1[i]!=s2[i])
			return false;
	}
	return true;

}

void getconditions(string fname,int arr[][N],int size){
	ifstream myfile;
	myfile.open(fname);
	string line;
	int count=0;
	while(getline(myfile,line)){
		count++;
		string keyword=line.substr(0,line.find('('));
		string s1="if";
		string s2="else";
	//	cout << keyword << endl;
		trim(keyword);
		if(stringcompare(s1,keyword)){
		//	cout << "if-found" << endl;
			arr[count][0]=count+1;
			if(m.find(count)==m.end()){
				arr[count][1]=count+2;
			}
			else{
				arr[count][1]=m[count];
			}
			complexity++;
		}
		if(stringcompare(s2,keyword)){

			arr[count][0]=count+1;
			if(m.find(count)==m.end()){
				arr[count][1]=count+2;
			}
			else{
				arr[count][1]=m[count];
			}
		}
	}
}

void getloops(string fname,int arr[][N],int size){
	ifstream myfile;
	myfile.open(fname);
	string line;
	int count=0;
	while(getline(myfile,line)){
		count++;
		string keyword=line.substr(0,line.find('('));
		string s1="for";
		string s2="while";
	//	cout << keyword << endl;
		trim(keyword);
		if(stringcompare(s1,keyword)){
		//	cout << "if-found" << endl;
			arr[count][0]=count+1;
			if(m.find(count)==m.end()){
				arr[count][1]=count+2;
			}
			else{
				arr[count][1]=m[count];
			}
			arr[m[count]][0]=m[count]+1;
			arr[m[count]][1]=count;
			complexity++;
		}
		if(stringcompare(s2,keyword)){

			arr[count][0]=count+1;
			if(m.find(count)==m.end()){
				arr[count][1]=count+2;
			}
			else{
				arr[count][1]=m[count];
			}
			arr[m[count]][0]=m[count]+1;
			arr[m[count]][1]=count;
			complexity++;
		}

	}
}

int main(){
	string fname;
	cout << "Enter filename" << endl;
	cin >> fname;
	int size=getblocks(fname);
	int arr[size+1][N];
	for(int i=0;i<=size;i++){
		arr[i][0]=i+1;
		arr[i][1]=-1;
	}
	getconditions(fname,arr,size);
	getloops(fname,arr,size);
	int a=1;
	for(auto it=m.begin();it!=m.end();it++){
		cout <<"Block "<<a<<": "<< it->first << " " << it->second << endl;
		a++;
	}

	cout << endl;
	cout << "Adejacency Matrix" << endl;
	for(int i=0;i<size;i++){
		cout << i << " ";
		for(int j=0;j<2;j++)
			if(arr[i][j]!=-1)
				cout << arr[i][j] << " ";
		cout << endl;
	}
	cout << endl;
	cout << "Cyclomatic complexity is: "<<complexity<<endl;
	return 0;
}
