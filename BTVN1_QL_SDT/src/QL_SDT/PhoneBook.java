package QL_SDT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

 class PhoneBook extends Phone {
	ArrayList<String> PhoneList = new ArrayList<>();

	@Override
	void insertPhone(String name, String phone) {
		// TODO Auto-generated method stub
		boolean found = false;
        for (int i = 0; i < PhoneList.size(); i++) {
            String[] entry = PhoneList.get(i).split(" : ");
            if (entry[0].equals(name)) {
                if (!entry[1].contains(phone)) {
                    PhoneList.set(i, entry[0] + " : " + entry[1] + " : " + phone);
                }
                found = true;
                break;
            }
        }
        if (!found) {
            PhoneList.add(name + " : " + phone);
        }
	}

	@Override
	void removePhone(String name) {
		// TODO Auto-generated method stub
		for (int i = 0; i < PhoneList.size(); i++) {
            if (PhoneList.get(i).startsWith(name + " :")) {
                PhoneList.remove(i);
                System.out.println("Đã xóa " + name + " khỏi danh bạ.");
                return;
            }
        }
        System.out.println("Không tìm thấy người dùng " + name + ".");
	}

	@Override
	void updatePhone(String name, String newphone) {
		// TODO Auto-generated method stub
		for (int i = 0; i < PhoneList.size(); i++) {
            String[] entry = PhoneList.get(i).split(" : ");
            if (entry[0].equals(name)) {
                PhoneList.set(i, entry[0] + " : " + newphone);
                System.out.println("Số điện thoại của " + name + " đã được cập nhật.");
                return;
            }
        }
        System.out.println("Không tìm thấy người dùng " + name + ".");
	}

	@Override
	void searchPhone(String name) {
		// TODO Auto-generated method stub
		for (String entry : PhoneList) {
            if (entry.startsWith(name + " :")) {
                System.out.println("Tìm thấy: " + entry);
                return;
            }
        }
        System.out.println("Không tìm thấy " + name + ".");
	}

	@Override
	void sort() {
		// TODO Auto-generated method stub
		 Collections.sort(PhoneList, new Comparator<String>() {
	            @Override
	            public int compare(String o1, String o2) {
	                return o1.split(" : ")[0].compareTo(o2.split(" : ")[0]);
	            }
	        });
	        System.out.println("Danh bạ đã được sắp xếp.");
	}
	

}
