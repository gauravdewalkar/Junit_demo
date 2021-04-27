insert into ITEM(id, name, price, quantity) values(10001,'Item1',10,20);
insert into ITEM(id, name, price, quantity) values(10002,'Item2',5,10);
insert into ITEM(id, name, price, quantity) values(10003,'Item3',15,2);




   HttpHeaders headers = new Headers();
    headers.setExpires(10000L);     
    ResponseEntity<String> responseEntity = new ResponseEntity<>("dummyString", headers, HttpStatus.OK);
    when(restTemplate.exchange( Matchers.anyString(), 
            Matchers.any(HttpMethod.class),
            Matchers.<HttpEntity<?>> any(), 
            Matchers.<Class<String>> any())).thenReturn(responseEntity);