/*Autor: Andres Giovanne Florez Perez*/

#include <bits/stdc++.h>
using namespace std;
int visi[18];
int prime[]={2,3,5,7,11,13,17,19,23,29,31,37};
void print(vector<int> L){
    for(int i=0;i<L.size();i++){
        cout<<L[i];
        if(i+1!=L.size())cout<<" ";

    }



}
bool check(int c,vector<int> L){
    for(int i=0;i<sizeof(prime);i++){
        if(c+L[L.size()-1]==prime[i])return true;

    }
    return false;


}

void f(vector<int> D,vector<int> output,int n){
    if(n==D.size()){
        if(check(1,output)){
            print(output);
            cout<<endl;
        }
        else{
            return ;
        }
    }
    else{
        for(int i=1;i<D.size();i++){
            if(visi[i])continue;
            int c = D[i];
            if(!visi[i] && check(c,output)){

                visi[i]=1;
                output.push_back(c);
                f(D,output,n+1);
                visi[i]=0;
                output.pop_back();

            }



        }


    }



}


int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int n;
    int cnt=1;

    while(cin>>n){
        vector<int> D;
        vector<int> out;
        out.push_back(1);

        for(int i=0;i<n;i++)D.push_back(i+1);
        for(int j=0;j<n;j++)visi[j]=0;
        cout<<"Case "<<cnt<<":"<<endl;
        f(D,out,1);
        cout<<endl;
        cnt++;
    }


    return 0;

}
