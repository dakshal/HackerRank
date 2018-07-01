int matchingpairs(string str) {
	if (!isUpperCase(str.at(0)) || str.size() == 0)
		return -1;
char array[str.size()];
	int pointer = 1;
array[0] = str.at(0);
	int res = -1;
	for (int i = 1; i < str.size(); i++) {
		if (!isUpperCase(str.at(i))) {
			char c = array[pointer-1];
			if (c + 32 == str.at(i)) {
      pointer--;
				res = i;
			} else
				return res;
		} else {
    array[pointer] = str.at(i);
    pointer++;
		}
	}
	if (pointer == 0)
		return str.size() - 1;
	else
		return res;
}

bool isUpperCase(char ch) {
	string str = "ABCDEFGHIGKLMNOPQRSTUVWXYZ";
	int pos = str.find(ch);
	if (pos >= 0)
		return true;
	else
		return false;
}