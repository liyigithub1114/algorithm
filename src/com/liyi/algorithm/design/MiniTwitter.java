package com.liyi.algorithm.design;

import java.util.*;

public class MiniTwitter {
    Map<Integer, List<Tweet>> userTwitter = null;//一个用户id发送的所有tweet
    Map<Integer,List<Integer>> userFriend = null;//一个用户所有的朋友id
    public MiniTwitter() {
        // do intialization if necessary
        userFriend = new HashMap<>();
        userTwitter = new HashMap<>();
    }

    /*
     * @param user_id: An integer
     * @param tweet_text: a string
     * @return: a tweet
     */
    public Tweet postTweet(int user_id, String tweet_text) {
        // write your code here
        Tweet tweet = Tweet.create(user_id, tweet_text);
        if(userTwitter.containsKey(user_id)){
            List<Tweet> tweets = userTwitter.get(user_id);
            tweets.add(tweet);
        }else{
            List<Tweet> tweets = new ArrayList<>();
            tweets.add(tweet);
            userTwitter.put(user_id,tweets);
        }
        return tweet;
    }

    /*
     * @param user_id: An integer
     * @return: a list of 10 new feeds recently and sort by timeline
     */
    public List<Tweet> getNewsFeed(int user_id) {
        // write your code here
        List<Tweet> list = new ArrayList<>();
        PriorityQueue<Tweet> queue = new PriorityQueue<>(new Comparator<Tweet>() {
            @Override
            public int compare(Tweet o1, Tweet o2) {
                return o2.id - o1.id;
            }
        });
        List<Tweet> mySelf = getTimeline(user_id);
        if(mySelf != null && !mySelf.isEmpty()){
            queue.addAll(mySelf);
        }
        if(userFriend.containsKey(user_id)){
            List<Integer> friends = userFriend.get(user_id);
            if(friends != null && !friends.isEmpty()){
                int size = friends.size();
                for(int i=0;i<size;i++){
                    int id = friends.get(i);
                    List<Tweet> timeline = getTimeline(id);
                    queue.addAll(timeline);
                }
            }
        }
        int index = 0;
        while(!queue.isEmpty() && index < 10){
            list.add(queue.poll());
            index++;
        }

        return list;
    }

    /*
     * @param user_id: An integer
     * @return: a list of 10 new posts recently and sort by timeline
     */
    public List<Tweet> getTimeline(int user_id) {
        // write your code here
        List<Tweet> res =new ArrayList<>();
        if (userTwitter.containsKey(user_id)){
            List<Tweet> tweets = userTwitter.get(user_id);
            if(tweets != null && !tweets.isEmpty()){
                int size = tweets.size() - 1;
                int index = 0;
                while(size >= 0 && index < 10){
                    res.add(tweets.get(size));
                    size--;
                    index++;
                }
            }
        }
        return res;
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void follow(int from_user_id, int to_user_id) {
        // write your code here
        if(userFriend.containsKey(from_user_id)){
            List<Integer> friends = userFriend.get(from_user_id);
            friends.add(to_user_id);
        }else{
            List<Integer> list = new ArrayList<>();
            list.add(to_user_id);
            userFriend.put(from_user_id,list);
        }
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void unfollow(int from_user_id, int to_user_id) {
        // write your code here
        if(userFriend.containsKey(from_user_id)){
            List<Integer> list = userFriend.get(from_user_id);
            if(list.contains(to_user_id)){
                list.remove(new Integer(to_user_id));
            }
        }
    }
}

//Definition of Tweet:a
class Tweet {
    public int id;
    public int user_id;
    public String text;
    public static Tweet create(int user_id, String tweet_text) {
        //This will create a new tweet object,
        //and auto fill id
        return new Tweet();
    }
}