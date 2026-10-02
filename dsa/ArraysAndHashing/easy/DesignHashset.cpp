class MyHashSet {
    vector<bool> hashSet;
public:
    MyHashSet() {
        hashSet.resize(1000001, false);
    }
    
    void add(int key) {
        hashSet[key] = true;
    }
    
    void remove(int key) {
        hashSet[key] = false;
    }
    
    bool contains(int key) {
        return hashSet[key];
    }
};

class MyHashSet {
    vector<list<int>> hashSet;
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
        vector<list<int>> updatedHashSet(N);
        for(auto itr: hashSet){
            for(auto val: itr){
                int index = getIndex(val);
                updatedHashSet[index].push_back(val);
            }
        }
        hashSet = updatedHashSet;
        N = 2*N;
    }

public:
    MyHashSet() {
        hashSet.resize(10001);
        N = 10000;
        n = 0;
    }
    
    void add(int key) {
        int index = getIndex(key);
        auto itr = find(hashSet[index].begin(), 
        hashSet[index].end(), key);
        if(itr == hashSet[index].end()){

            hashSet[index].push_back(key);
            n++;
        }
        rehashIfRequired();
    }
    
    void remove(int key) {
        int index = getIndex(key);
        auto itr = find(hashSet[index].begin(), 
        hashSet[index].end(), key);
        if(itr != hashSet[index].end()){
            hashSet[index].erase(itr);
            n--;
        }
    }
    
    bool contains(int key) {
        int index = getIndex(key);
        auto itr = find(hashSet[index].begin(), 
        hashSet[index].end(), key);
        return (itr != hashSet[index].end());
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */