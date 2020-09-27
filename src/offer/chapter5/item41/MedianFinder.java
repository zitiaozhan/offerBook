package offer.chapter5.item41;

class MedianFinder {
    private Heap fir = new Heap(25000, false);
    private Heap sec = new Heap(25000, true);

    public MedianFinder() {

    }

    public void addNum(int num) {
        int firVal = fir.peek();
        int secVal = sec.peek();
        if (num < firVal) {
            fir.add(num);
        } else if (num > secVal) {
            sec.add(num);
        } else {
            if (fir.size() > sec.size()) {
                sec.add(num);
            } else {
                fir.add(num);
            }
            return;
        }
        int diff = fir.size() - sec.size();
        if (diff < 0) {
            int n = sec.pop();
            fir.add(n);
        } else if (diff > 1) {
            int n = fir.pop();
            sec.add(n);
        }
    }

    public double findMedian() {
        int diff = fir.size() - sec.size();
        return diff == 1 ? fir.peek() : ((double)fir.peek() + (double)sec.peek()) / 2;
    }

    public static class Heap {
        private int[] arrays;
        private int offset = 0;
        private boolean isAsc;

        public Heap(int size, boolean isAsc) {
            this.arrays = new int[size + 1];
            this.isAsc = isAsc;
        }

        public void add(int val) {
            offset += 1;
            arrays[offset] = val;

            int parent;
            int current = offset;
            while ((parent = (current / 2)) != 0 && needReplace(val, arrays[parent])) {
                arrays[current] = arrays[parent];
                arrays[parent] = val;
                current = parent;
            }
        }

        private boolean needReplace(int current, int target) {
            if (isAsc) {
                return current < target;
            } else {
                return current > target;
            }
        }

        public int peek() {
            return arrays[1];
        }

        public int size() {
            return offset;
        }

        public int pop() {
            if (size() == 0) {
                throw new IllegalArgumentException("Empty");
            }

            int val = arrays[1];
            int lastVal = arrays[offset];
            arrays[offset] = 0;
            offset--;

            arrays[1] = lastVal;

            int current = 1;
            do {
                int leftOffset = current * 2;
                if (leftOffset > offset) {
                    break;
                }

                int targetOffset;
                int rightOffset = leftOffset + 1;
                if (rightOffset > offset) {
                    targetOffset = leftOffset;
                } else {
                    targetOffset = needReplace(arrays[leftOffset], arrays[rightOffset]) ? leftOffset : rightOffset;
                }
                if (needReplace(arrays[targetOffset], arrays[current])) {
                    arrays[current] = arrays[targetOffset];
                    arrays[targetOffset] = lastVal;
                    current = targetOffset;
                } else {
                    break;
                }
            } while (true);
            return val;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */