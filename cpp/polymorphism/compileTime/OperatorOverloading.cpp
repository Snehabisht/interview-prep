#include<iostream>
#include<string>
#include <list>
using namespace std;

struct YoutubeChannel {
    string name;
    int subscribersCount;

    YoutubeChannel(s tring name, int subscribersCount) {
        this->name = name;
        this->subscribersCount = subscribersCount;
    }

    bool operator==(const YoutubeChannel &other) const { // since library functions like list::remove() take const reference as parameter, we need to make this operator function const as well
        return this->name == other.name && this->subscribersCount == other.subscribersCount;
    }
};

ostream& operator<<(ostream &COUT, YoutubeChannel &youtubeChannel) {
        COUT << "Channel Name: " << youtubeChannel.name << endl;
        COUT << "Subscribers: " << youtubeChannel.subscribersCount << endl;
        return COUT;
}


struct MyCollection {
    list<YoutubeChannel> mychannels;

    void operator+=(YoutubeChannel &youtubeChannel) {
        this->mychannels.push_back(youtubeChannel);
    }

    void operator-=(YoutubeChannel &youtubeChannel) {
        this->mychannels.remove(youtubeChannel);  
    }
};

ostream& operator<<(ostream &COUT, MyCollection mycollection){
    for(auto mychannel: mycollection.mychannels) {
        COUT << "Channel Name: " << mychannel.name << endl;
        COUT << "Subscribers: " << mychannel.subscribersCount << endl;
    }
    return COUT;
}


int main() {
    YoutubeChannel channel1 = YoutubeChannel("TechWorld", 100000);
    YoutubeChannel channel2 = YoutubeChannel("TechWorld2", 200000);
    // cout<<channel1 ; /* here cout is one operand and channel1 is the other */
    cout<<channel1<<channel2 ; /* here cout is one operand and channel2 is the other */
    operator<<(cout, channel1); //another way to call operator<< function explicitly
    MyCollection myCollection;
    myCollection += channel1; // here myCollection will be available automatically as the first operand as "this"
    myCollection += channel2; 
    myCollection -= channel1; // here myCollection will be available automatically as the first operand as "this"
    cout<<myCollection; // another ostream operator overloading
    return 0;
}
