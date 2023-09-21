package com.example.springjpa.objects;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

import java.util.*;

public class MutableHttpServletRequest extends HttpServletRequestWrapper {

    private final Map<String, String> customHeaders;

    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request The request to wrap
     * @throws IllegalArgumentException if the request is null
     */
    public MutableHttpServletRequest(HttpServletRequest request) {
        super(request);
        this.customHeaders = new HashMap<>();
    }

    public void setHeader(String title, String value) {
        this.customHeaders.put(title, value);
    }

    @Override
    public String getHeader(String name) {

        String value = customHeaders.get(name);
        System.out.println(this.customHeaders.get("user"));

        if(value!=null){
            return value;
        }
        return super.getHeader(name);
    }


    @Override
    public Enumeration<String> getHeaderNames() {

        List<String> list = new ArrayList<String>(this.customHeaders.keySet());

        Enumeration<String> enumerate = super.getHeaderNames();

        while (enumerate.hasMoreElements()){
            list.add(enumerate.nextElement());
        }

        return Collections.enumeration(list);
    }
}
