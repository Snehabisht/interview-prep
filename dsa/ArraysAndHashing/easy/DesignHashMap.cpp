class MyHashMap {
    vector<int> hashMap;
public:
    MyHashMap() {
       hashMap.resize(1e6+1, -1); 
    }
    
    void put(int key, int value) {
        hashMap[key] = value;
    }
    
    int get(int key) {
        return hashMap[key];
    }
    
    void remove(int key) {
        hashMap[key] = -1;
    }
};

class MyHashMap {
    vector<list<pair<int,int>>> hashMap;
    int N; // no of buckets/bucket size
    int n; // elements present

    int getIndex(int key){
        return key%N;
    }

    bool isRehashRequired() {
        double lf = n/N;
        return (lf > 0.75);
    }

    void rehashIfRequired(){
        if(!isRehashRequired()) return;
        N = 2*N;
        vector<list<pair<int,int>>> updatedHashMap(N);
        for(auto &itr: hashMap){
            for(auto &p: itr){
                int index = getIndex(p.first);
                updatedHashMap[index].push_back(p);
            }
        }
        hashMap = updatedHashMap;
    }
public:
    MyHashMap() {
        hashMap.resize(10001);
        N = 10000;
        n = 0;
    }
    
    void put(int key, int value) {
        int index = getIndex(key);
        auto& chain = hashMap[index];
        for(auto &itr : chain){
            if(itr.first == key){
                itr.second = value;
                return;
            }
        }
        chain.push_back({key, value});
        rehashIfRequired();
    }

    int get(int key) {
        int index = getIndex(key);
        auto& chain = hashMap[index];
        for(auto &itr : chain){
            if(itr.first == key){
                return itr.second;
            }
        }
        return -1;
    }
    
    void remove(int key) {
        int index = getIndex(key);
        auto& chain = hashMap[index];
        for(auto itr = chain.begin(); itr!=chain.end(); ++itr){
            if(itr->first == key){
                chain.erase(itr);
                return;
            }
        }
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */