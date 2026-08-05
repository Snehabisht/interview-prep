#include<iostream>
using namespace std;

void getMinAndMax(int arr[], int size, int* min, int* max) {
    for(int i=1; i<size; i++) {
        if(arr[i] < *min) {
            *min = arr[i];
        }
        if(arr[i] > *max) {
            *max = arr[i];
        }
        cout<<*min<<" "<<*max<<endl;
    }
}

void getMinAndMax(int arr[], int size, int &min, int &max) {
    for(int i=1; i<size; i++) {
        if(arr[i] < min) {
            min = arr[i];
        }
        if(arr[i] > max) {
            max = arr[i];
        }
        cout<<min<<" "<<max<<endl;
    }
}

int main() {
    int arr[] = {5, 2, 8, 1, 9};
    int size = sizeof(arr)/sizeof(arr[0]);
    int min = arr[0];
    int max = arr[0];
    getMinAndMax(arr, size, &min, &max);
    cout << "Minimum value: " << min << endl;
    cout << "Maximum value: " << max << endl;

    int arr2[] = {51, -92, 8, 11, 19};
    size = sizeof(arr2)/sizeof(arr2[0]);
    min = arr2[0];
    max = arr2[0];
    //passing min and max by reference
    getMinAndMax(arr2, size, min, max);
    cout << "Minimum value: " << min << endl;
    cout << "Maximum value: " << max << endl;
    return 0;
}