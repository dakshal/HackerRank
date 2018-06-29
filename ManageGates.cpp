int findMinGates(vector<int> arrivals, vector<int> departures, int flight) {
		sort(departures.begin(), departures.end());
		int count = 0;
		int pointer = 0;
		for (int i = 1; i < flight; i++) {
			if (arrivals[i] >= departures[pointer]) {
				pointer++;
			} else {
				count++;
			}
		}
		return count;
	}