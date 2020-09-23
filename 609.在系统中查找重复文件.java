纯基础操作 哈希map 字符串的操作
将路径字符串通过空格分开成为一个字符串数组 字符串数组的第一个值为路径 后续的值为文件名
通过哈希map建立<文件内容，文件完整路径>这样的键值对 
最后删除文件内容小于2的键值对即可
class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> list = new ArrayList<List<String>>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		int index = 0;
		for (String str : paths) {
			String[] strs = str.split(" ");
			for (int i = 1; i < strs.length; i++) {
				String key = strs[i].substring(strs[i].indexOf("(") + 1, strs[i].indexOf(")"));
				if (!map.containsKey(key)) {
					map.put(key, index++);
					list.add(new ArrayList<String>());
				}
				list.get(map.get(key)).add(strs[0] + "/" + strs[i].substring(0, strs[i].indexOf("(")));
			}
		}
		for (int i = list.size() - 1; i >= 0; i--) {
			if (list.get(i).size() < 2) 
				list.remove(i);
		}
		return list;
    }
}