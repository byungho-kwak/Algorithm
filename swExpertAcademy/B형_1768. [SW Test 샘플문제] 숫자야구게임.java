// 50개 testcase.
// max query 초과 시 오답 처리
// 구현해야 하는 부분
class UserSolution {
    static Solution.Result result1;
    static Solution.Result result2;
    public void doUserImplementation(int guess[]) {
    	
    	int[] a = new int[4];
    	int[] b = new int[4];
    	int[] c = new int[2];
    	int[] twoBall = new int[4];
    	int aCnt = 0;
    	int bCnt = 0;
    	for(int i=0; i<4; i++) {
    		a[i] = i;
    		b[i] = i+4;
    	}
		c[0] = 8;
		c[1] = 9;
		
		result1 = Solution.query(a);
		if(result1.strike==4) { 
			copy(a, guess);
			return;
		}
		result2 = Solution.query(b);
		if(result2.strike==4) {
			copy(b, guess);
			return;
		}
			
		aCnt = result1.ball + result1.strike;
		bCnt = result2.ball + result2.strike;
    	
		if(aCnt==0) {
			if(bCnt==4) {
				fourBall(b);
				copy(b,guess);
				return;
			} else if(bCnt==3) {
				threeBall(b, c, guess);
				fourBall(guess);
				return;
				
			} else if(bCnt==2) {
				twoBall(b, c, guess);
				fourBall(guess);
				return;
			}
		} 
		else if(aCnt==1) {
			if(bCnt==3) {
				threeBall(b, a, guess);
				fourBall(guess);
				return;
			} else if(bCnt==2) {
				oneBall(a, c, twoBall);
				twoBall(twoBall, b, guess);
				fourBall(guess);
				return;
			} else if(bCnt==1) {
				oneBall(a, b, twoBall);
				twoBall(twoBall, c, guess);
				fourBall(guess);
				return;
			}
		} 
		else if(aCnt==2) {
			if(bCnt==2) {
				twoBall(a, b, guess);
				fourBall(guess);
				return;
			} else if(bCnt==1) {
				oneBall(b, c, twoBall);
				twoBall(twoBall, a, guess);
				fourBall(guess);
				return;
			} else if(bCnt==0) {
				twoBall(a, c, guess);
				fourBall(guess);
				return;
			}
		} 
		else if(aCnt==3) {
			if(bCnt==1) {
				threeBall(a, b, guess);
				fourBall(guess);
				return;
			} else if(bCnt==0) {
				threeBall(a, c, guess);
				fourBall(guess);
				return;
			}
		} 
		else if(aCnt==4) {
			fourBall(a);
			copy(a, guess);
			return;
		}
    }
    
    void fourBall(int[] f) {
    	
    	boolean[] check = new boolean[4];
    	int[] temp = new int[4];
    	Solution.Result tempResult;
    	
    	for(int i=0; i<4; i++) {
    		check[i]=true;
    		temp[0] = f[i];
    		for(int j=0; j<4; j++) {
    			if(!check[j]) {
	    			check[j]=true;
	    			temp[1] = f[j];
	    			for(int k=0; k<4; k++) {
	    				if(!check[k]) {
		    				temp[2] = f[k];
		    				check[k]=true;
		    				for(int l=0; l<4; l++) {
		    					if(!check[l]) {
			    					temp[3] = f[l];
			    					tempResult = Solution.query(temp);
			    					if(tempResult.strike==4) {
			    						copy(temp, f);
			    						return;
			    					}
		    					}
		    				}
		    				check[k]=false;
		    			}
	    			}
	    			check[j]=false;
	    		}
    		}
    		check[i]=false;
    	}
    }
    
    void threeBall(int[] f1, int[] f2, int[] result) {
    	Solution.Result tempResult;
    	int f2Len = f2.length;
    	int[] temp = new int[4];
    	for(int i=0; i<4; i++)
    		temp[i] = f1[i];
    	
    	// 첫번재 매개변수 : 3-ball, 두번재 매개변수 : 1-ball,
		for(int i=0; i<f2Len; i++) {
			for(int j=0; j<4; j++) {
				temp[j] = f2[i];
				tempResult = Solution.query(temp);
				if(tempResult.ball + tempResult.strike == 4) {
					copy(temp, result);
					return;
				}
				temp[j] = f1[j];
			}
		}
    }
    
    // f1, f2 둘 다 one-Ball
    void oneBall(int[] f1, int[] f2, int[] twoBall) {
    	Solution.Result tempResult;
    	int f2Len = f2.length;
    	int[] temp = new int[4];
    	for(int i=0; i<4; i++)
    		temp[i] = f1[i];

		for(int i=0; i<4; i++) {
			for(int j=0; j<f2Len; j++) {
				temp[i] = f2[j];
				tempResult = Solution.query(temp);
				if(tempResult.ball + tempResult.strike == 2) {
					copy(temp, twoBall);
					return;
				}
				temp[i] = f1[i];
			}
		}
	}
    // f1, f2 둘 다 two-Ball
    void twoBall(int[] f1, int[] f2, int[] result) {
    	Solution.Result tempResult;
    	int[] temp = new int[4];
    	int f2Len = f2.length;
    	
    	for(int i=0; i<3; i++) {
    		for(int j=i+1; j<4; j++) {
    			temp[0] = f1[i];
    			temp[1] = f1[j];
    	    	for(int k=0; k<f2Len-1; k++) {
    	    		for(int l=k+1; l<f2Len; l++) {
    	    			temp[2] = f2[k];
    	    			temp[3] = f2[l];
    	    			
    					tempResult = Solution.query(temp);
    					if(tempResult.ball + tempResult.strike == 4) {
    						copy(temp, result);
    						return;
    					}
    	    		}
    	    	}
    		}
    	}
    }
    
    // f1을 f2에 복사
    void copy(int[] f1, int[] f2) {
    	for(int i=0; i<4; i++)
    		f2[i] = f1[i];
    }
}