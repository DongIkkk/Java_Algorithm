package D3;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.StringTokenizer;

public class Sol1230LinkedList {
    static class MyLinkedList {
        private Node headNode;
        private int size;

        public MyLinkedList() {
            headNode = new Node();
            size = 0;
        }

        // 그냥 add
        public void add(Object data) {
            Node newNode = new Node(data);
            Node node = headNode;

            for (int i = 0; i < size; i++) {
                node = node.nextNode;
            }

            newNode.nextNode = node.nextNode;
            node.nextNode = newNode;
            size++;
        }

        // 인덱스받은 add
        public void add(int idx, Object data) {
            Node newNode = new Node(data);
            Node node = headNode;

            for (int i = 0; i < idx; i++) {
                node = node.nextNode;
            }

            newNode.nextNode = node.nextNode;
            node.nextNode = newNode;
            size++;
        }

        // 삭제
        public void remove(int idx) {
            Node node = headNode;
            for (int i = 0; i < idx; i++) {
                node = node.nextNode;
            }

            Node delNode = node.nextNode;
            node.nextNode = delNode.nextNode;
            size--;
        }



        // 처음 노드값 반환
        public Object popFirst() {
            Node node = headNode.nextNode;
            headNode.nextNode = node.nextNode;
            Object result = node.data;
            size--;
            return result;
        }

        // 노드
        class Node {
            public Node nextNode;
            public Object data;

            public Node() {}

            public Node(Object data) {
                this.nextNode = null;
                this.data = data;
            }
        }

    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int tc=1; tc<=10; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());

            MyLinkedList ll = new MyLinkedList();

            while(st.hasMoreTokens()) {
                ll.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            char type = '0';
            int x, y, s;
            st = new StringTokenizer(br.readLine());
            while(command!=0) {
                type = st.nextToken().charAt(0);
                command--;
                switch (type) {
                    case 'I':
                        x = Integer.parseInt(st.nextToken());
                        y = Integer.parseInt(st.nextToken());

                        for(int i=0; i<y; i++) {
                            s = Integer.parseInt(st.nextToken());
                            ll.add(x+i, s);
                        }
                        break;
                    case 'A':
                        y = Integer.parseInt(st.nextToken());

                        for(int i=0; i<y; i++) {
                            s = Integer.parseInt(st.nextToken());
                            ll.add(s);
                        }
                        break;
                    case 'D':
                        x = Integer.parseInt(st.nextToken());
                        y = Integer.parseInt(st.nextToken());

                        for(int i=0; i<y; i++) {
                            ll.remove(x);
                        }
                        break;
                }

            }

            System.out.printf("#%d ",tc);
            for(int i =0; i<10; i++) {
                System.out.printf("%d ",ll.popFirst());
            }
            System.out.println();
        }

    }
}
