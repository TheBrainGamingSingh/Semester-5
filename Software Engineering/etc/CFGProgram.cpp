#include<iostream>
#include<fstream>
#include<string>
#include<vector>
#include<utility>

using namespace std;

int main() {

    int linecount=0;
    vector< pair<int,int> > edges;
    string line;
    vector<string> inputlines;
    ifstream fin;
    fin.open("testcode.txt");
    while (fin) {
        linecount++;
        getline(fin, line);
        inputlines.push_back(line);
        }
    fin.close();

 	linecount--;


    for(int i=1;i<linecount;i++)
    {
        string cur =inputlines[i-1]; int end;
        std::size_t found = cur.find("if");
        if(found!=std::string::npos)
        {   int start =i;
            for(int j=i+1;j<=linecount;j++)
            { string next = inputlines[j];
               std::size_t found2 = next.find("else{");
                if(found2==std::string::npos){}
                else{
                    edges.push_back(make_pair(start,j+1));
                    for(int k=start;k<j+1;k++)
                    edges.push_back(make_pair(k,k+1));end =j;
                    break;
                	}

            }
            i=end;


        }
       else edges.push_back(make_pair(i,i+1));
    }
    for(int i=0;i<edges.size();i++){
        cout<<"Edge between " << edges[i].first << " and "<<edges[i].second;
        cout<<"\n";}

return 0;
}
