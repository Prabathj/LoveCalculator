package com.prabathj.lc.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LCResultCalculationImpl implements LCResultCalculation {

	@Value("${relationship.key}")
	private String keyOfRelationship;
	
	private enum Relationship{
		F{
			public String getName() {
				return "Family";
			}
		},
		L{
			public String getName() {
				return "Love";
			}
		},
		A{
			public String getName() {
				return "Affection";
			}
		},
		M{
			public String getName() {
				return "Marriage";
			}
		},
		E{
			public String getName() {
				return "Enemy";
			}
		};
		
		public abstract String getName();
	}
	
	@Override
	public String calculateRelationship(String user, String crush) {
		
		int finalS=0,sizeOfkey=0,indexOfRelationship=0;
		
		finalS=user.length()+crush.length();
		
		sizeOfkey =keyOfRelationship.length();
		
		indexOfRelationship =finalS%sizeOfkey;
		
		char rel_char=keyOfRelationship.charAt(indexOfRelationship);
	
		Relationship obj=Relationship.valueOf(String.valueOf(rel_char));
		
		return obj.getName();
	}

}
