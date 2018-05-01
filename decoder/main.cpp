#include <bits/stdc++.h>

#define dot 160//On
#define dash 120//Off
#define space 80//Off
#define sep 40//On
#define fault 5
using namespace std;
    string data = "";
    string MorseData = "";
    bool last = false;
    bool sep = false;
    int cnt = 0;


bool readFromPhotoResistor() {
    return true | false;
}

string decode() {
    // decode
    return "";
}

void showData() {
    //print data
}

void loop {
    bool is = readFromPhotoResistor();
    if (last^is) {
        if (is == false) {
            if (abs(cnt-dot)<fault) {
                MorseData+=".";
            }
            else if (abs(cnt-dash)<fault) {
                MorseData+="-";
            }
            else if (abs(cnt-space)<fault) {
                MorseData+=" ";
            }
            else if (abs(cnt-sep)<fault) {
                MorseData+="|";
                data = decode();
                MorseData = "";
                showData();
            }
        }
        cnt = 0;
        last = is;
    }
    if (is) {
        cnt++;
    }
    delay(1);
}

int main() {
    //init display

    while(true) {
        loop();
    }
    return 0;
}

/*



*/
