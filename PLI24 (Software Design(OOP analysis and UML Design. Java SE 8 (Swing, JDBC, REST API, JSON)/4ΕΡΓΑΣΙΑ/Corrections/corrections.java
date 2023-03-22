   
   
   
   
    private void subprogram()  
    {
        if ("functionTK".equals(token.type.name()))  
        {
            token = lex.nextToken();
            if ("idTK".equals(token.type.name()))
            {
                token = lex.nextToken();
                if ("leftpTK".equals(token.type.name()))
                {
                    token = lex.nextToken();
                    formal_arguments();    // <---------- correction here
                    if ("rightpTK".equals(token.type.name()))
                    {
                        token = lex.nextToken();
                        if ("colTK".equals(token.type.name()))
                        {
                            token = lex.nextToken();
                            datatype();   // <---------- correction here
                            declarations();
                            statements();
                            if ("endfunctionTK".equals(token.type.name()))
                            {
                                token = lex.nextToken();
                            } else error("endfunction expected");
                        } else error("colon expected");
                    }
                    else error("right parenthesis expected");
                } else error("left parenthesis expected");
            } else error("id expected");
        System.out.println(symbol_table);
        symbol_table.remove_local_entities();
        }
        
        else if ("procedureTK".equals(token.type.name()))   
        {
            token = lex.nextToken();
            if ("idTK".equals(token.type.name()))
            {
                token = lex.nextToken();
                if ("leftpTK".equals(token.type.name()))
                {
                    token = lex.nextToken();
                    formal_arguments();   // <---------- correction here
                    if ("rightpTK".equals(token.type.name()))
                    {
                        token = lex.nextToken();
                        declarations();
                        statements();
                        if ("endprocedureTK".equals(token.type.name()))
                        {
                            token = lex.nextToken();
                        } else error("endprocedure expected");
                    } else error("right parenthesis expected");
                } else error("left parenthesis expected");
            } else error("id expected");
            System.out.println(symbol_table);
            symbol_table.remove_local_entities();
        }        
    }
    
    
    
    
    private void expression(){
        sign();
        term();
        while ("plusTK".equals(token.type.name()) || "minusTK".equals(token.type.name())){
            token = lex.nextToken();
            term();   // <---------- correction here
        }
    }


          
    
   public void addEntity(Entity e){
        for (Entity x : entities){	
            if (e.name.equals(x.name)){
                System.out.println("Entity "+e.name+ " already declared" );
                System.exit(-1);
            }            
        }
        if (e instanceof Variable || e instanceof FormalParameter){ 
            int location = 0;
            for (Entity x : entities){ 
                if (x instanceof Variable){ 
                    if ("integer".equals(((Variable)x).type)){  
                        location += 4;
                    }
                    if ("real".equals(((Variable)x).type)){ 
                        location += 8;
                    }           
                }
                else if (x instanceof FormalParameter){   // <---------- correction here
                    if ("integer".equals(((FormalParameter)x).type)){
                        location += 4;
                    }
                    if ("real".equals(((FormalParameter)x).type)){
                        location += 8;
                    }
                }
            if (e instanceof Variable) 
                    ((Variable)e).location = location;
            if (e instanceof FormalParameter)
                    ((FormalParameter)e).location = location;
            }
        }
        entities.add(e); 
    }

    
    
    

