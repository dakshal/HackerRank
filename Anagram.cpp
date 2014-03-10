#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
	int t,x;
	cin>>t;
    int count[26];
    while(t--)
    {
        for(int i=0 ;  i<26 ; i++)
            count[i] = 0;
        int sum =0;
        string str;
        cin>>str;
        x = str.length();
        
        if(x%2==1)
            cout<<"-1"<<endl;
        else
        {
            for(int i=0 ; i<x/2 ; i++)
                count[str[i] - 'a']++;
            for(int i=x/2 ; i<x ; i++)
                count[str[i] - 'a']--;
            
            for(int i=0 ; i<26 ; i++)
            {
                sum = sum + abs(count[i]);
            }
            sum = sum/2;
            cout<<sum<<endl;
        }
    }
    return 0;
}
