package org.palladiosimulator.pcm.pcmstoex.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.palladiosimulator.pcm.pcmstoex.services.PCMStoExGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalPCMStoExParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_DOT", "RULE_CONDDELIMITER", "RULE_ELSEDELIMITER", "RULE_POW", "RULE_NOT", "RULE_DOUBLE", "RULE_SQUARE_PAREN_L", "RULE_SQUARE_PAREN_R", "RULE_LPAREN", "RULE_RPAREN", "RULE_ID", "RULE_COLON", "RULE_BOOLEAN_KEYWORDS", "RULE_STRING", "RULE_DECINT", "RULE_DOUBLEPDF", "RULE_INTPMF", "RULE_DOUBLEPMF", "RULE_ENUMPMF", "RULE_ORDERED_DEF", "RULE_BOOLPMF", "RULE_SEMI", "RULE_DIGIT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'-'", "'/'", "'*'", "'TYPE'", "'BYTESIZE'", "'NUMBER_OF_ELEMENTS'", "'VALUE'", "'STRUCTURE'", "'AND'", "'OR'", "'XOR'", "'>'", "'<'", "'=='", "'<>'", "'>='", "'<='", "'+'", "'%'", "'_'", "'unitless'", "'B'", "'s'", "'m'"
    };
    public static final int RULE_ID=14;
    public static final int RULE_CONDDELIMITER=5;
    public static final int RULE_ANY_OTHER=30;
    public static final int RULE_DOUBLEPMF=21;
    public static final int RULE_DOUBLEPDF=19;
    public static final int RULE_ENUMPMF=22;
    public static final int EOF=-1;
    public static final int RULE_NOT=8;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int RULE_DOT=4;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int RULE_POW=7;
    public static final int RULE_LPAREN=12;
    public static final int RULE_BOOLPMF=24;
    public static final int RULE_ORDERED_DEF=23;
    public static final int T__50=50;
    public static final int RULE_ELSEDELIMITER=6;
    public static final int RULE_SEMI=25;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_SL_COMMENT=28;
    public static final int RULE_DOUBLE=9;
    public static final int RULE_ML_COMMENT=27;
    public static final int T__31=31;
    public static final int RULE_COLON=15;
    public static final int T__32=32;
    public static final int RULE_STRING=17;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_DECINT=18;
    public static final int RULE_INTPMF=20;
    public static final int RULE_RPAREN=13;
    public static final int RULE_WS=29;
    public static final int RULE_DIGIT=26;
    public static final int RULE_BOOLEAN_KEYWORDS=16;
    public static final int RULE_SQUARE_PAREN_R=11;
    public static final int RULE_SQUARE_PAREN_L=10;

    // delegates
    // delegators


        public InternalPCMStoExParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalPCMStoExParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalPCMStoExParser.tokenNames; }
    public String getGrammarFileName() { return "../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     
     	private PCMStoExGrammarAccess grammarAccess;
     	
        public InternalPCMStoExParser(TokenStream input, PCMStoExGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "ausdruck";	
       	}
       	
       	@Override
       	protected PCMStoExGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleausdruck"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:74:1: entryRuleausdruck returns [EObject current=null] : iv_ruleausdruck= ruleausdruck EOF ;
    public final EObject entryRuleausdruck() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleausdruck = null;


        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:75:2: (iv_ruleausdruck= ruleausdruck EOF )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:76:2: iv_ruleausdruck= ruleausdruck EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAusdruckRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleausdruck_in_entryRuleausdruck81);
            iv_ruleausdruck=ruleausdruck();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleausdruck; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleausdruck91); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleausdruck"


    // $ANTLR start "ruleausdruck"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:83:1: ruleausdruck returns [EObject current=null] : this_expression_0= ruleexpression ;
    public final EObject ruleausdruck() throws RecognitionException {
        EObject current = null;

        EObject this_expression_0 = null;


         enterRule(); 
            
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:86:28: (this_expression_0= ruleexpression )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:88:2: this_expression_0= ruleexpression
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAusdruckAccess().getExpressionParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleexpression_in_ruleausdruck140);
            this_expression_0=ruleexpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_expression_0; 
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleausdruck"


    // $ANTLR start "entryRuleVariable"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:107:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:108:2: (iv_ruleVariable= ruleVariable EOF )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:109:2: iv_ruleVariable= ruleVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVariable_in_entryRuleVariable174);
            iv_ruleVariable=ruleVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariable; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVariable184); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:116:1: ruleVariable returns [EObject current=null] : this_CharacterisedVariable_0= ruleCharacterisedVariable ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        EObject this_CharacterisedVariable_0 = null;


         enterRule(); 
            
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:119:28: (this_CharacterisedVariable_0= ruleCharacterisedVariable )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:121:2: this_CharacterisedVariable_0= ruleCharacterisedVariable
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getVariableAccess().getCharacterisedVariableParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleCharacterisedVariable_in_ruleVariable233);
            this_CharacterisedVariable_0=ruleCharacterisedVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_CharacterisedVariable_0; 
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRuleCharacterisedVariable"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:140:1: entryRuleCharacterisedVariable returns [EObject current=null] : iv_ruleCharacterisedVariable= ruleCharacterisedVariable EOF ;
    public final EObject entryRuleCharacterisedVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCharacterisedVariable = null;


        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:141:2: (iv_ruleCharacterisedVariable= ruleCharacterisedVariable EOF )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:142:2: iv_ruleCharacterisedVariable= ruleCharacterisedVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCharacterisedVariableRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCharacterisedVariable_in_entryRuleCharacterisedVariable267);
            iv_ruleCharacterisedVariable=ruleCharacterisedVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCharacterisedVariable; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCharacterisedVariable277); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCharacterisedVariable"


    // $ANTLR start "ruleCharacterisedVariable"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:149:1: ruleCharacterisedVariable returns [EObject current=null] : ( ( (lv_id_Variable_0_0= ruleVariableReference ) ) this_DOT_1= RULE_DOT ( (lv_characterisationType_2_0= ruleVariableCharacterisationType ) ) ) ;
    public final EObject ruleCharacterisedVariable() throws RecognitionException {
        EObject current = null;

        Token this_DOT_1=null;
        EObject lv_id_Variable_0_0 = null;

        Enumerator lv_characterisationType_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:152:28: ( ( ( (lv_id_Variable_0_0= ruleVariableReference ) ) this_DOT_1= RULE_DOT ( (lv_characterisationType_2_0= ruleVariableCharacterisationType ) ) ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:153:1: ( ( (lv_id_Variable_0_0= ruleVariableReference ) ) this_DOT_1= RULE_DOT ( (lv_characterisationType_2_0= ruleVariableCharacterisationType ) ) )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:153:1: ( ( (lv_id_Variable_0_0= ruleVariableReference ) ) this_DOT_1= RULE_DOT ( (lv_characterisationType_2_0= ruleVariableCharacterisationType ) ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:153:2: ( (lv_id_Variable_0_0= ruleVariableReference ) ) this_DOT_1= RULE_DOT ( (lv_characterisationType_2_0= ruleVariableCharacterisationType ) )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:153:2: ( (lv_id_Variable_0_0= ruleVariableReference ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:154:1: (lv_id_Variable_0_0= ruleVariableReference )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:154:1: (lv_id_Variable_0_0= ruleVariableReference )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:155:3: lv_id_Variable_0_0= ruleVariableReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCharacterisedVariableAccess().getId_VariableVariableReferenceParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVariableReference_in_ruleCharacterisedVariable323);
            lv_id_Variable_0_0=ruleVariableReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getCharacterisedVariableRule());
              	        }
                     		set(
                     			current, 
                     			"id_Variable",
                      		lv_id_Variable_0_0, 
                      		"VariableReference");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            this_DOT_1=(Token)match(input,RULE_DOT,FollowSets000.FOLLOW_RULE_DOT_in_ruleCharacterisedVariable334); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_DOT_1, grammarAccess.getCharacterisedVariableAccess().getDOTTerminalRuleCall_1()); 
                  
            }
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:175:1: ( (lv_characterisationType_2_0= ruleVariableCharacterisationType ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:176:1: (lv_characterisationType_2_0= ruleVariableCharacterisationType )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:176:1: (lv_characterisationType_2_0= ruleVariableCharacterisationType )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:177:3: lv_characterisationType_2_0= ruleVariableCharacterisationType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCharacterisedVariableAccess().getCharacterisationTypeVariableCharacterisationTypeEnumRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVariableCharacterisationType_in_ruleCharacterisedVariable354);
            lv_characterisationType_2_0=ruleVariableCharacterisationType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getCharacterisedVariableRule());
              	        }
                     		set(
                     			current, 
                     			"characterisationType",
                      		lv_characterisationType_2_0, 
                      		"VariableCharacterisationType");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCharacterisedVariable"


    // $ANTLR start "entryRuleexpression"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:201:1: entryRuleexpression returns [EObject current=null] : iv_ruleexpression= ruleexpression EOF ;
    public final EObject entryRuleexpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleexpression = null;


        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:202:2: (iv_ruleexpression= ruleexpression EOF )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:203:2: iv_ruleexpression= ruleexpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleexpression_in_entryRuleexpression390);
            iv_ruleexpression=ruleexpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleexpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleexpression400); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleexpression"


    // $ANTLR start "ruleexpression"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:210:1: ruleexpression returns [EObject current=null] : this_ifelseExpr_0= ruleifelseExpr ;
    public final EObject ruleexpression() throws RecognitionException {
        EObject current = null;

        EObject this_ifelseExpr_0 = null;


         enterRule(); 
            
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:213:28: (this_ifelseExpr_0= ruleifelseExpr )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:215:2: this_ifelseExpr_0= ruleifelseExpr
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getExpressionAccess().getIfelseExprParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleifelseExpr_in_ruleexpression449);
            this_ifelseExpr_0=ruleifelseExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_ifelseExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleexpression"


    // $ANTLR start "entryRuleifelseExpr"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:234:1: entryRuleifelseExpr returns [EObject current=null] : iv_ruleifelseExpr= ruleifelseExpr EOF ;
    public final EObject entryRuleifelseExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleifelseExpr = null;


        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:235:2: (iv_ruleifelseExpr= ruleifelseExpr EOF )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:236:2: iv_ruleifelseExpr= ruleifelseExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfelseExprRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleifelseExpr_in_entryRuleifelseExpr483);
            iv_ruleifelseExpr=ruleifelseExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleifelseExpr; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleifelseExpr493); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleifelseExpr"


    // $ANTLR start "ruleifelseExpr"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:243:1: ruleifelseExpr returns [EObject current=null] : (this_boolAndExpr_0= ruleboolAndExpr ( () this_CONDDELIMITER_2= RULE_CONDDELIMITER ( (lv_ifExpression_3_0= ruleboolAndExpr ) ) this_ELSEDELIMITER_4= RULE_ELSEDELIMITER ( (lv_elseExpression_5_0= ruleboolAndExpr ) ) )? ) ;
    public final EObject ruleifelseExpr() throws RecognitionException {
        EObject current = null;

        Token this_CONDDELIMITER_2=null;
        Token this_ELSEDELIMITER_4=null;
        EObject this_boolAndExpr_0 = null;

        EObject lv_ifExpression_3_0 = null;

        EObject lv_elseExpression_5_0 = null;


         enterRule(); 
            
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:246:28: ( (this_boolAndExpr_0= ruleboolAndExpr ( () this_CONDDELIMITER_2= RULE_CONDDELIMITER ( (lv_ifExpression_3_0= ruleboolAndExpr ) ) this_ELSEDELIMITER_4= RULE_ELSEDELIMITER ( (lv_elseExpression_5_0= ruleboolAndExpr ) ) )? ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:247:1: (this_boolAndExpr_0= ruleboolAndExpr ( () this_CONDDELIMITER_2= RULE_CONDDELIMITER ( (lv_ifExpression_3_0= ruleboolAndExpr ) ) this_ELSEDELIMITER_4= RULE_ELSEDELIMITER ( (lv_elseExpression_5_0= ruleboolAndExpr ) ) )? )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:247:1: (this_boolAndExpr_0= ruleboolAndExpr ( () this_CONDDELIMITER_2= RULE_CONDDELIMITER ( (lv_ifExpression_3_0= ruleboolAndExpr ) ) this_ELSEDELIMITER_4= RULE_ELSEDELIMITER ( (lv_elseExpression_5_0= ruleboolAndExpr ) ) )? )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:248:2: this_boolAndExpr_0= ruleboolAndExpr ( () this_CONDDELIMITER_2= RULE_CONDDELIMITER ( (lv_ifExpression_3_0= ruleboolAndExpr ) ) this_ELSEDELIMITER_4= RULE_ELSEDELIMITER ( (lv_elseExpression_5_0= ruleboolAndExpr ) ) )?
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getIfelseExprAccess().getBoolAndExprParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleboolAndExpr_in_ruleifelseExpr543);
            this_boolAndExpr_0=ruleboolAndExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_boolAndExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:259:1: ( () this_CONDDELIMITER_2= RULE_CONDDELIMITER ( (lv_ifExpression_3_0= ruleboolAndExpr ) ) this_ELSEDELIMITER_4= RULE_ELSEDELIMITER ( (lv_elseExpression_5_0= ruleboolAndExpr ) ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_CONDDELIMITER) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:259:2: () this_CONDDELIMITER_2= RULE_CONDDELIMITER ( (lv_ifExpression_3_0= ruleboolAndExpr ) ) this_ELSEDELIMITER_4= RULE_ELSEDELIMITER ( (lv_elseExpression_5_0= ruleboolAndExpr ) )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:259:2: ()
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:260:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getIfelseExprAccess().getIfElseExpressionConditionExpressionAction_1_0(),
                                  current);
                          
                    }

                    }

                    this_CONDDELIMITER_2=(Token)match(input,RULE_CONDDELIMITER,FollowSets000.FOLLOW_RULE_CONDDELIMITER_in_ruleifelseExpr566); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_CONDDELIMITER_2, grammarAccess.getIfelseExprAccess().getCONDDELIMITERTerminalRuleCall_1_1()); 
                          
                    }
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:272:1: ( (lv_ifExpression_3_0= ruleboolAndExpr ) )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:273:1: (lv_ifExpression_3_0= ruleboolAndExpr )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:273:1: (lv_ifExpression_3_0= ruleboolAndExpr )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:274:3: lv_ifExpression_3_0= ruleboolAndExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIfelseExprAccess().getIfExpressionBoolAndExprParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleboolAndExpr_in_ruleifelseExpr586);
                    lv_ifExpression_3_0=ruleboolAndExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getIfelseExprRule());
                      	        }
                             		set(
                             			current, 
                             			"ifExpression",
                              		lv_ifExpression_3_0, 
                              		"boolAndExpr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    this_ELSEDELIMITER_4=(Token)match(input,RULE_ELSEDELIMITER,FollowSets000.FOLLOW_RULE_ELSEDELIMITER_in_ruleifelseExpr597); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ELSEDELIMITER_4, grammarAccess.getIfelseExprAccess().getELSEDELIMITERTerminalRuleCall_1_3()); 
                          
                    }
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:294:1: ( (lv_elseExpression_5_0= ruleboolAndExpr ) )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:295:1: (lv_elseExpression_5_0= ruleboolAndExpr )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:295:1: (lv_elseExpression_5_0= ruleboolAndExpr )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:296:3: lv_elseExpression_5_0= ruleboolAndExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIfelseExprAccess().getElseExpressionBoolAndExprParserRuleCall_1_4_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleboolAndExpr_in_ruleifelseExpr617);
                    lv_elseExpression_5_0=ruleboolAndExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getIfelseExprRule());
                      	        }
                             		set(
                             			current, 
                             			"elseExpression",
                              		lv_elseExpression_5_0, 
                              		"boolAndExpr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleifelseExpr"


    // $ANTLR start "entryRuleboolAndExpr"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:322:1: entryRuleboolAndExpr returns [EObject current=null] : iv_ruleboolAndExpr= ruleboolAndExpr EOF ;
    public final EObject entryRuleboolAndExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleboolAndExpr = null;


        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:323:2: (iv_ruleboolAndExpr= ruleboolAndExpr EOF )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:324:2: iv_ruleboolAndExpr= ruleboolAndExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBoolAndExprRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleboolAndExpr_in_entryRuleboolAndExpr657);
            iv_ruleboolAndExpr=ruleboolAndExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleboolAndExpr; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleboolAndExpr667); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleboolAndExpr"


    // $ANTLR start "ruleboolAndExpr"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:331:1: ruleboolAndExpr returns [EObject current=null] : (this_boolOrExpr_0= ruleboolOrExpr ( () ( (lv_operation_2_0= ruleandoperation ) ) ( (lv_right_3_0= ruleboolOrExpr ) ) )* ) ;
    public final EObject ruleboolAndExpr() throws RecognitionException {
        EObject current = null;

        EObject this_boolOrExpr_0 = null;

        Enumerator lv_operation_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:334:28: ( (this_boolOrExpr_0= ruleboolOrExpr ( () ( (lv_operation_2_0= ruleandoperation ) ) ( (lv_right_3_0= ruleboolOrExpr ) ) )* ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:335:1: (this_boolOrExpr_0= ruleboolOrExpr ( () ( (lv_operation_2_0= ruleandoperation ) ) ( (lv_right_3_0= ruleboolOrExpr ) ) )* )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:335:1: (this_boolOrExpr_0= ruleboolOrExpr ( () ( (lv_operation_2_0= ruleandoperation ) ) ( (lv_right_3_0= ruleboolOrExpr ) ) )* )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:336:2: this_boolOrExpr_0= ruleboolOrExpr ( () ( (lv_operation_2_0= ruleandoperation ) ) ( (lv_right_3_0= ruleboolOrExpr ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getBoolAndExprAccess().getBoolOrExprParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleboolOrExpr_in_ruleboolAndExpr717);
            this_boolOrExpr_0=ruleboolOrExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_boolOrExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:347:1: ( () ( (lv_operation_2_0= ruleandoperation ) ) ( (lv_right_3_0= ruleboolOrExpr ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==39) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:347:2: () ( (lv_operation_2_0= ruleandoperation ) ) ( (lv_right_3_0= ruleboolOrExpr ) )
            	    {
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:347:2: ()
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:348:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getBoolAndExprAccess().getBooleanOperatorExpressionLeftAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:356:2: ( (lv_operation_2_0= ruleandoperation ) )
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:357:1: (lv_operation_2_0= ruleandoperation )
            	    {
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:357:1: (lv_operation_2_0= ruleandoperation )
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:358:3: lv_operation_2_0= ruleandoperation
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getBoolAndExprAccess().getOperationAndoperationEnumRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleandoperation_in_ruleboolAndExpr750);
            	    lv_operation_2_0=ruleandoperation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getBoolAndExprRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operation",
            	              		lv_operation_2_0, 
            	              		"andoperation");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:374:2: ( (lv_right_3_0= ruleboolOrExpr ) )
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:375:1: (lv_right_3_0= ruleboolOrExpr )
            	    {
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:375:1: (lv_right_3_0= ruleboolOrExpr )
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:376:3: lv_right_3_0= ruleboolOrExpr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getBoolAndExprAccess().getRightBoolOrExprParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleboolOrExpr_in_ruleboolAndExpr771);
            	    lv_right_3_0=ruleboolOrExpr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getBoolAndExprRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"boolOrExpr");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleboolAndExpr"


    // $ANTLR start "entryRuleboolOrExpr"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:400:1: entryRuleboolOrExpr returns [EObject current=null] : iv_ruleboolOrExpr= ruleboolOrExpr EOF ;
    public final EObject entryRuleboolOrExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleboolOrExpr = null;


        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:401:2: (iv_ruleboolOrExpr= ruleboolOrExpr EOF )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:402:2: iv_ruleboolOrExpr= ruleboolOrExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBoolOrExprRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleboolOrExpr_in_entryRuleboolOrExpr809);
            iv_ruleboolOrExpr=ruleboolOrExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleboolOrExpr; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleboolOrExpr819); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleboolOrExpr"


    // $ANTLR start "ruleboolOrExpr"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:409:1: ruleboolOrExpr returns [EObject current=null] : (this_compareExpr_0= rulecompareExpr ( () ( (lv_operation_2_0= ruleoroperations ) ) ( (lv_right_3_0= rulecompareExpr ) ) )* ) ;
    public final EObject ruleboolOrExpr() throws RecognitionException {
        EObject current = null;

        EObject this_compareExpr_0 = null;

        Enumerator lv_operation_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:412:28: ( (this_compareExpr_0= rulecompareExpr ( () ( (lv_operation_2_0= ruleoroperations ) ) ( (lv_right_3_0= rulecompareExpr ) ) )* ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:413:1: (this_compareExpr_0= rulecompareExpr ( () ( (lv_operation_2_0= ruleoroperations ) ) ( (lv_right_3_0= rulecompareExpr ) ) )* )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:413:1: (this_compareExpr_0= rulecompareExpr ( () ( (lv_operation_2_0= ruleoroperations ) ) ( (lv_right_3_0= rulecompareExpr ) ) )* )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:414:2: this_compareExpr_0= rulecompareExpr ( () ( (lv_operation_2_0= ruleoroperations ) ) ( (lv_right_3_0= rulecompareExpr ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getBoolOrExprAccess().getCompareExprParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_rulecompareExpr_in_ruleboolOrExpr869);
            this_compareExpr_0=rulecompareExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_compareExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:425:1: ( () ( (lv_operation_2_0= ruleoroperations ) ) ( (lv_right_3_0= rulecompareExpr ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=40 && LA3_0<=41)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:425:2: () ( (lv_operation_2_0= ruleoroperations ) ) ( (lv_right_3_0= rulecompareExpr ) )
            	    {
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:425:2: ()
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:426:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getBoolOrExprAccess().getBooleanOperatorExpressionLeftAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:434:2: ( (lv_operation_2_0= ruleoroperations ) )
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:435:1: (lv_operation_2_0= ruleoroperations )
            	    {
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:435:1: (lv_operation_2_0= ruleoroperations )
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:436:3: lv_operation_2_0= ruleoroperations
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getBoolOrExprAccess().getOperationOroperationsEnumRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleoroperations_in_ruleboolOrExpr902);
            	    lv_operation_2_0=ruleoroperations();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getBoolOrExprRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operation",
            	              		lv_operation_2_0, 
            	              		"oroperations");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:452:2: ( (lv_right_3_0= rulecompareExpr ) )
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:453:1: (lv_right_3_0= rulecompareExpr )
            	    {
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:453:1: (lv_right_3_0= rulecompareExpr )
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:454:3: lv_right_3_0= rulecompareExpr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getBoolOrExprAccess().getRightCompareExprParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_rulecompareExpr_in_ruleboolOrExpr923);
            	    lv_right_3_0=rulecompareExpr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getBoolOrExprRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"compareExpr");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleboolOrExpr"


    // $ANTLR start "entryRulecompareExpr"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:478:1: entryRulecompareExpr returns [EObject current=null] : iv_rulecompareExpr= rulecompareExpr EOF ;
    public final EObject entryRulecompareExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_rulecompareExpr = null;


        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:479:2: (iv_rulecompareExpr= rulecompareExpr EOF )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:480:2: iv_rulecompareExpr= rulecompareExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCompareExprRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulecompareExpr_in_entryRulecompareExpr961);
            iv_rulecompareExpr=rulecompareExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulecompareExpr; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulecompareExpr971); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulecompareExpr"


    // $ANTLR start "rulecompareExpr"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:487:1: rulecompareExpr returns [EObject current=null] : (this_sumExpr_0= rulesumExpr ( () ( (lv_operation_2_0= ruleCompareOperations ) ) ( (lv_right_3_0= rulesumExpr ) ) )? ) ;
    public final EObject rulecompareExpr() throws RecognitionException {
        EObject current = null;

        EObject this_sumExpr_0 = null;

        Enumerator lv_operation_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:490:28: ( (this_sumExpr_0= rulesumExpr ( () ( (lv_operation_2_0= ruleCompareOperations ) ) ( (lv_right_3_0= rulesumExpr ) ) )? ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:491:1: (this_sumExpr_0= rulesumExpr ( () ( (lv_operation_2_0= ruleCompareOperations ) ) ( (lv_right_3_0= rulesumExpr ) ) )? )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:491:1: (this_sumExpr_0= rulesumExpr ( () ( (lv_operation_2_0= ruleCompareOperations ) ) ( (lv_right_3_0= rulesumExpr ) ) )? )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:492:2: this_sumExpr_0= rulesumExpr ( () ( (lv_operation_2_0= ruleCompareOperations ) ) ( (lv_right_3_0= rulesumExpr ) ) )?
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getCompareExprAccess().getSumExprParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_rulesumExpr_in_rulecompareExpr1021);
            this_sumExpr_0=rulesumExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_sumExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:503:1: ( () ( (lv_operation_2_0= ruleCompareOperations ) ) ( (lv_right_3_0= rulesumExpr ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=42 && LA4_0<=47)) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:503:2: () ( (lv_operation_2_0= ruleCompareOperations ) ) ( (lv_right_3_0= rulesumExpr ) )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:503:2: ()
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:504:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getCompareExprAccess().getCompareExpressionLeftAction_1_0(),
                                  current);
                          
                    }

                    }

                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:512:2: ( (lv_operation_2_0= ruleCompareOperations ) )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:513:1: (lv_operation_2_0= ruleCompareOperations )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:513:1: (lv_operation_2_0= ruleCompareOperations )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:514:3: lv_operation_2_0= ruleCompareOperations
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCompareExprAccess().getOperationCompareOperationsEnumRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCompareOperations_in_rulecompareExpr1054);
                    lv_operation_2_0=ruleCompareOperations();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCompareExprRule());
                      	        }
                             		set(
                             			current, 
                             			"operation",
                              		lv_operation_2_0, 
                              		"CompareOperations");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:530:2: ( (lv_right_3_0= rulesumExpr ) )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:531:1: (lv_right_3_0= rulesumExpr )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:531:1: (lv_right_3_0= rulesumExpr )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:532:3: lv_right_3_0= rulesumExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCompareExprAccess().getRightSumExprParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulesumExpr_in_rulecompareExpr1075);
                    lv_right_3_0=rulesumExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCompareExprRule());
                      	        }
                             		set(
                             			current, 
                             			"right",
                              		lv_right_3_0, 
                              		"sumExpr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulecompareExpr"


    // $ANTLR start "entryRulesumExpr"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:556:1: entryRulesumExpr returns [EObject current=null] : iv_rulesumExpr= rulesumExpr EOF ;
    public final EObject entryRulesumExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_rulesumExpr = null;


        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:557:2: (iv_rulesumExpr= rulesumExpr EOF )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:558:2: iv_rulesumExpr= rulesumExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSumExprRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulesumExpr_in_entryRulesumExpr1113);
            iv_rulesumExpr=rulesumExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulesumExpr; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulesumExpr1123); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulesumExpr"


    // $ANTLR start "rulesumExpr"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:565:1: rulesumExpr returns [EObject current=null] : (this_prodExpr_0= ruleprodExpr ( () ( (lv_operation_2_0= ruleTermOperations ) ) ( (lv_right_3_0= ruleprodExpr ) ) )* ) ;
    public final EObject rulesumExpr() throws RecognitionException {
        EObject current = null;

        EObject this_prodExpr_0 = null;

        Enumerator lv_operation_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:568:28: ( (this_prodExpr_0= ruleprodExpr ( () ( (lv_operation_2_0= ruleTermOperations ) ) ( (lv_right_3_0= ruleprodExpr ) ) )* ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:569:1: (this_prodExpr_0= ruleprodExpr ( () ( (lv_operation_2_0= ruleTermOperations ) ) ( (lv_right_3_0= ruleprodExpr ) ) )* )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:569:1: (this_prodExpr_0= ruleprodExpr ( () ( (lv_operation_2_0= ruleTermOperations ) ) ( (lv_right_3_0= ruleprodExpr ) ) )* )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:570:2: this_prodExpr_0= ruleprodExpr ( () ( (lv_operation_2_0= ruleTermOperations ) ) ( (lv_right_3_0= ruleprodExpr ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getSumExprAccess().getProdExprParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleprodExpr_in_rulesumExpr1173);
            this_prodExpr_0=ruleprodExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_prodExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:581:1: ( () ( (lv_operation_2_0= ruleTermOperations ) ) ( (lv_right_3_0= ruleprodExpr ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==31||LA5_0==48) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:581:2: () ( (lv_operation_2_0= ruleTermOperations ) ) ( (lv_right_3_0= ruleprodExpr ) )
            	    {
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:581:2: ()
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:582:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getSumExprAccess().getTermExpressionLeftAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:590:2: ( (lv_operation_2_0= ruleTermOperations ) )
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:591:1: (lv_operation_2_0= ruleTermOperations )
            	    {
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:591:1: (lv_operation_2_0= ruleTermOperations )
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:592:3: lv_operation_2_0= ruleTermOperations
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSumExprAccess().getOperationTermOperationsEnumRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleTermOperations_in_rulesumExpr1206);
            	    lv_operation_2_0=ruleTermOperations();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSumExprRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operation",
            	              		lv_operation_2_0, 
            	              		"TermOperations");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:608:2: ( (lv_right_3_0= ruleprodExpr ) )
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:609:1: (lv_right_3_0= ruleprodExpr )
            	    {
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:609:1: (lv_right_3_0= ruleprodExpr )
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:610:3: lv_right_3_0= ruleprodExpr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSumExprAccess().getRightProdExprParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleprodExpr_in_rulesumExpr1227);
            	    lv_right_3_0=ruleprodExpr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSumExprRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"prodExpr");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulesumExpr"


    // $ANTLR start "entryRuleprodExpr"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:634:1: entryRuleprodExpr returns [EObject current=null] : iv_ruleprodExpr= ruleprodExpr EOF ;
    public final EObject entryRuleprodExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleprodExpr = null;


        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:635:2: (iv_ruleprodExpr= ruleprodExpr EOF )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:636:2: iv_ruleprodExpr= ruleprodExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProdExprRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleprodExpr_in_entryRuleprodExpr1265);
            iv_ruleprodExpr=ruleprodExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleprodExpr; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleprodExpr1275); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleprodExpr"


    // $ANTLR start "ruleprodExpr"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:643:1: ruleprodExpr returns [EObject current=null] : (this_powExpr_0= rulepowExpr ( () ( (lv_operation_2_0= ruleProductOperations ) ) ( (lv_right_3_0= rulepowExpr ) ) )* ) ;
    public final EObject ruleprodExpr() throws RecognitionException {
        EObject current = null;

        EObject this_powExpr_0 = null;

        Enumerator lv_operation_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:646:28: ( (this_powExpr_0= rulepowExpr ( () ( (lv_operation_2_0= ruleProductOperations ) ) ( (lv_right_3_0= rulepowExpr ) ) )* ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:647:1: (this_powExpr_0= rulepowExpr ( () ( (lv_operation_2_0= ruleProductOperations ) ) ( (lv_right_3_0= rulepowExpr ) ) )* )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:647:1: (this_powExpr_0= rulepowExpr ( () ( (lv_operation_2_0= ruleProductOperations ) ) ( (lv_right_3_0= rulepowExpr ) ) )* )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:648:2: this_powExpr_0= rulepowExpr ( () ( (lv_operation_2_0= ruleProductOperations ) ) ( (lv_right_3_0= rulepowExpr ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getProdExprAccess().getPowExprParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_rulepowExpr_in_ruleprodExpr1325);
            this_powExpr_0=rulepowExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_powExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:659:1: ( () ( (lv_operation_2_0= ruleProductOperations ) ) ( (lv_right_3_0= rulepowExpr ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=32 && LA6_0<=33)||LA6_0==49) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:659:2: () ( (lv_operation_2_0= ruleProductOperations ) ) ( (lv_right_3_0= rulepowExpr ) )
            	    {
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:659:2: ()
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:660:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getProdExprAccess().getProductExpressionLeftAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:668:2: ( (lv_operation_2_0= ruleProductOperations ) )
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:669:1: (lv_operation_2_0= ruleProductOperations )
            	    {
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:669:1: (lv_operation_2_0= ruleProductOperations )
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:670:3: lv_operation_2_0= ruleProductOperations
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProdExprAccess().getOperationProductOperationsEnumRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleProductOperations_in_ruleprodExpr1358);
            	    lv_operation_2_0=ruleProductOperations();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getProdExprRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operation",
            	              		lv_operation_2_0, 
            	              		"ProductOperations");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:686:2: ( (lv_right_3_0= rulepowExpr ) )
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:687:1: (lv_right_3_0= rulepowExpr )
            	    {
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:687:1: (lv_right_3_0= rulepowExpr )
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:688:3: lv_right_3_0= rulepowExpr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProdExprAccess().getRightPowExprParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_rulepowExpr_in_ruleprodExpr1379);
            	    lv_right_3_0=rulepowExpr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getProdExprRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"powExpr");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleprodExpr"


    // $ANTLR start "entryRulepowExpr"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:712:1: entryRulepowExpr returns [EObject current=null] : iv_rulepowExpr= rulepowExpr EOF ;
    public final EObject entryRulepowExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_rulepowExpr = null;


        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:713:2: (iv_rulepowExpr= rulepowExpr EOF )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:714:2: iv_rulepowExpr= rulepowExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPowExprRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulepowExpr_in_entryRulepowExpr1417);
            iv_rulepowExpr=rulepowExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulepowExpr; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulepowExpr1427); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulepowExpr"


    // $ANTLR start "rulepowExpr"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:721:1: rulepowExpr returns [EObject current=null] : (this_unaryExpr_0= ruleunaryExpr ( () this_POW_2= RULE_POW ( (lv_exponent_3_0= ruleunaryExpr ) ) )? ) ;
    public final EObject rulepowExpr() throws RecognitionException {
        EObject current = null;

        Token this_POW_2=null;
        EObject this_unaryExpr_0 = null;

        EObject lv_exponent_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:724:28: ( (this_unaryExpr_0= ruleunaryExpr ( () this_POW_2= RULE_POW ( (lv_exponent_3_0= ruleunaryExpr ) ) )? ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:725:1: (this_unaryExpr_0= ruleunaryExpr ( () this_POW_2= RULE_POW ( (lv_exponent_3_0= ruleunaryExpr ) ) )? )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:725:1: (this_unaryExpr_0= ruleunaryExpr ( () this_POW_2= RULE_POW ( (lv_exponent_3_0= ruleunaryExpr ) ) )? )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:726:2: this_unaryExpr_0= ruleunaryExpr ( () this_POW_2= RULE_POW ( (lv_exponent_3_0= ruleunaryExpr ) ) )?
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getPowExprAccess().getUnaryExprParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleunaryExpr_in_rulepowExpr1477);
            this_unaryExpr_0=ruleunaryExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_unaryExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:737:1: ( () this_POW_2= RULE_POW ( (lv_exponent_3_0= ruleunaryExpr ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_POW) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:737:2: () this_POW_2= RULE_POW ( (lv_exponent_3_0= ruleunaryExpr ) )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:737:2: ()
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:738:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getPowExprAccess().getPowerExpressionBaseAction_1_0(),
                                  current);
                          
                    }

                    }

                    this_POW_2=(Token)match(input,RULE_POW,FollowSets000.FOLLOW_RULE_POW_in_rulepowExpr1500); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_POW_2, grammarAccess.getPowExprAccess().getPOWTerminalRuleCall_1_1()); 
                          
                    }
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:750:1: ( (lv_exponent_3_0= ruleunaryExpr ) )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:751:1: (lv_exponent_3_0= ruleunaryExpr )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:751:1: (lv_exponent_3_0= ruleunaryExpr )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:752:3: lv_exponent_3_0= ruleunaryExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPowExprAccess().getExponentUnaryExprParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleunaryExpr_in_rulepowExpr1520);
                    lv_exponent_3_0=ruleunaryExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPowExprRule());
                      	        }
                             		set(
                             			current, 
                             			"exponent",
                              		lv_exponent_3_0, 
                              		"unaryExpr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulepowExpr"


    // $ANTLR start "entryRuleunaryExpr"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:776:1: entryRuleunaryExpr returns [EObject current=null] : iv_ruleunaryExpr= ruleunaryExpr EOF ;
    public final EObject entryRuleunaryExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleunaryExpr = null;


        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:777:2: (iv_ruleunaryExpr= ruleunaryExpr EOF )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:778:2: iv_ruleunaryExpr= ruleunaryExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryExprRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleunaryExpr_in_entryRuleunaryExpr1558);
            iv_ruleunaryExpr=ruleunaryExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleunaryExpr; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleunaryExpr1568); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleunaryExpr"


    // $ANTLR start "ruleunaryExpr"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:785:1: ruleunaryExpr returns [EObject current=null] : (this_NegativeExpression_0= ruleNegativeExpression | this_NotExpression_1= ruleNotExpression | this_atom_2= ruleatom ) ;
    public final EObject ruleunaryExpr() throws RecognitionException {
        EObject current = null;

        EObject this_NegativeExpression_0 = null;

        EObject this_NotExpression_1 = null;

        EObject this_atom_2 = null;


         enterRule(); 
            
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:788:28: ( (this_NegativeExpression_0= ruleNegativeExpression | this_NotExpression_1= ruleNotExpression | this_atom_2= ruleatom ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:789:1: (this_NegativeExpression_0= ruleNegativeExpression | this_NotExpression_1= ruleNotExpression | this_atom_2= ruleatom )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:789:1: (this_NegativeExpression_0= ruleNegativeExpression | this_NotExpression_1= ruleNotExpression | this_atom_2= ruleatom )
            int alt8=3;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt8=1;
                }
                break;
            case RULE_NOT:
                {
                alt8=2;
                }
                break;
            case RULE_DOUBLE:
            case RULE_LPAREN:
            case RULE_ID:
            case RULE_BOOLEAN_KEYWORDS:
            case RULE_STRING:
            case RULE_DECINT:
            case RULE_DOUBLEPDF:
            case RULE_INTPMF:
            case RULE_DOUBLEPMF:
            case RULE_ENUMPMF:
            case RULE_BOOLPMF:
                {
                alt8=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:790:2: this_NegativeExpression_0= ruleNegativeExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getUnaryExprAccess().getNegativeExpressionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNegativeExpression_in_ruleunaryExpr1618);
                    this_NegativeExpression_0=ruleNegativeExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_NegativeExpression_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:803:2: this_NotExpression_1= ruleNotExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getUnaryExprAccess().getNotExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNotExpression_in_ruleunaryExpr1648);
                    this_NotExpression_1=ruleNotExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_NotExpression_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:816:2: this_atom_2= ruleatom
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getUnaryExprAccess().getAtomParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleatom_in_ruleunaryExpr1678);
                    this_atom_2=ruleatom();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_atom_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleunaryExpr"


    // $ANTLR start "entryRuleNotExpression"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:835:1: entryRuleNotExpression returns [EObject current=null] : iv_ruleNotExpression= ruleNotExpression EOF ;
    public final EObject entryRuleNotExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotExpression = null;


        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:836:2: (iv_ruleNotExpression= ruleNotExpression EOF )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:837:2: iv_ruleNotExpression= ruleNotExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNotExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNotExpression_in_entryRuleNotExpression1713);
            iv_ruleNotExpression=ruleNotExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNotExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNotExpression1723); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNotExpression"


    // $ANTLR start "ruleNotExpression"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:844:1: ruleNotExpression returns [EObject current=null] : (this_NOT_0= RULE_NOT ( (lv_inner_1_0= ruleunaryExpr ) ) ) ;
    public final EObject ruleNotExpression() throws RecognitionException {
        EObject current = null;

        Token this_NOT_0=null;
        EObject lv_inner_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:847:28: ( (this_NOT_0= RULE_NOT ( (lv_inner_1_0= ruleunaryExpr ) ) ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:848:1: (this_NOT_0= RULE_NOT ( (lv_inner_1_0= ruleunaryExpr ) ) )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:848:1: (this_NOT_0= RULE_NOT ( (lv_inner_1_0= ruleunaryExpr ) ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:848:2: this_NOT_0= RULE_NOT ( (lv_inner_1_0= ruleunaryExpr ) )
            {
            this_NOT_0=(Token)match(input,RULE_NOT,FollowSets000.FOLLOW_RULE_NOT_in_ruleNotExpression1759); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_NOT_0, grammarAccess.getNotExpressionAccess().getNOTTerminalRuleCall_0()); 
                  
            }
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:852:1: ( (lv_inner_1_0= ruleunaryExpr ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:853:1: (lv_inner_1_0= ruleunaryExpr )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:853:1: (lv_inner_1_0= ruleunaryExpr )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:854:3: lv_inner_1_0= ruleunaryExpr
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNotExpressionAccess().getInnerUnaryExprParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleunaryExpr_in_ruleNotExpression1779);
            lv_inner_1_0=ruleunaryExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNotExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"inner",
                      		lv_inner_1_0, 
                      		"unaryExpr");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNotExpression"


    // $ANTLR start "entryRuleNegativeExpression"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:878:1: entryRuleNegativeExpression returns [EObject current=null] : iv_ruleNegativeExpression= ruleNegativeExpression EOF ;
    public final EObject entryRuleNegativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNegativeExpression = null;


        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:879:2: (iv_ruleNegativeExpression= ruleNegativeExpression EOF )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:880:2: iv_ruleNegativeExpression= ruleNegativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNegativeExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNegativeExpression_in_entryRuleNegativeExpression1815);
            iv_ruleNegativeExpression=ruleNegativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNegativeExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNegativeExpression1825); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNegativeExpression"


    // $ANTLR start "ruleNegativeExpression"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:887:1: ruleNegativeExpression returns [EObject current=null] : (otherlv_0= '-' ( (lv_inner_1_0= ruleunaryExpr ) ) ) ;
    public final EObject ruleNegativeExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_inner_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:890:28: ( (otherlv_0= '-' ( (lv_inner_1_0= ruleunaryExpr ) ) ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:891:1: (otherlv_0= '-' ( (lv_inner_1_0= ruleunaryExpr ) ) )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:891:1: (otherlv_0= '-' ( (lv_inner_1_0= ruleunaryExpr ) ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:891:3: otherlv_0= '-' ( (lv_inner_1_0= ruleunaryExpr ) )
            {
            otherlv_0=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleNegativeExpression1862); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getNegativeExpressionAccess().getHyphenMinusKeyword_0());
                  
            }
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:895:1: ( (lv_inner_1_0= ruleunaryExpr ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:896:1: (lv_inner_1_0= ruleunaryExpr )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:896:1: (lv_inner_1_0= ruleunaryExpr )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:897:3: lv_inner_1_0= ruleunaryExpr
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNegativeExpressionAccess().getInnerUnaryExprParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleunaryExpr_in_ruleNegativeExpression1883);
            lv_inner_1_0=ruleunaryExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNegativeExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"inner",
                      		lv_inner_1_0, 
                      		"unaryExpr");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNegativeExpression"


    // $ANTLR start "entryRuleatom"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:921:1: entryRuleatom returns [EObject current=null] : iv_ruleatom= ruleatom EOF ;
    public final EObject entryRuleatom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleatom = null;


        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:922:2: (iv_ruleatom= ruleatom EOF )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:923:2: iv_ruleatom= ruleatom EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAtomRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleatom_in_entryRuleatom1919);
            iv_ruleatom=ruleatom();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleatom; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleatom1929); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleatom"


    // $ANTLR start "ruleatom"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:930:1: ruleatom returns [EObject current=null] : (this_IntLiteral_0= ruleIntLiteral | this_DoubleLiteral_1= ruleDoubleLiteral | this_StringLiteral_2= ruleStringLiteral | this_BoolLiteral_3= ruleBoolLiteral | this_FunctionLiteral_4= ruleFunctionLiteral | this_Variable_5= ruleVariable | this_Parenthesis_6= ruleParenthesis | this_ProbabilityFunctionLiteral_7= ruleProbabilityFunctionLiteral ) ;
    public final EObject ruleatom() throws RecognitionException {
        EObject current = null;

        EObject this_IntLiteral_0 = null;

        EObject this_DoubleLiteral_1 = null;

        EObject this_StringLiteral_2 = null;

        EObject this_BoolLiteral_3 = null;

        EObject this_FunctionLiteral_4 = null;

        EObject this_Variable_5 = null;

        EObject this_Parenthesis_6 = null;

        EObject this_ProbabilityFunctionLiteral_7 = null;


         enterRule(); 
            
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:933:28: ( (this_IntLiteral_0= ruleIntLiteral | this_DoubleLiteral_1= ruleDoubleLiteral | this_StringLiteral_2= ruleStringLiteral | this_BoolLiteral_3= ruleBoolLiteral | this_FunctionLiteral_4= ruleFunctionLiteral | this_Variable_5= ruleVariable | this_Parenthesis_6= ruleParenthesis | this_ProbabilityFunctionLiteral_7= ruleProbabilityFunctionLiteral ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:934:1: (this_IntLiteral_0= ruleIntLiteral | this_DoubleLiteral_1= ruleDoubleLiteral | this_StringLiteral_2= ruleStringLiteral | this_BoolLiteral_3= ruleBoolLiteral | this_FunctionLiteral_4= ruleFunctionLiteral | this_Variable_5= ruleVariable | this_Parenthesis_6= ruleParenthesis | this_ProbabilityFunctionLiteral_7= ruleProbabilityFunctionLiteral )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:934:1: (this_IntLiteral_0= ruleIntLiteral | this_DoubleLiteral_1= ruleDoubleLiteral | this_StringLiteral_2= ruleStringLiteral | this_BoolLiteral_3= ruleBoolLiteral | this_FunctionLiteral_4= ruleFunctionLiteral | this_Variable_5= ruleVariable | this_Parenthesis_6= ruleParenthesis | this_ProbabilityFunctionLiteral_7= ruleProbabilityFunctionLiteral )
            int alt9=8;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:935:2: this_IntLiteral_0= ruleIntLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAtomAccess().getIntLiteralParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleIntLiteral_in_ruleatom1979);
                    this_IntLiteral_0=ruleIntLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_IntLiteral_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:948:2: this_DoubleLiteral_1= ruleDoubleLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAtomAccess().getDoubleLiteralParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleDoubleLiteral_in_ruleatom2009);
                    this_DoubleLiteral_1=ruleDoubleLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_DoubleLiteral_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:961:2: this_StringLiteral_2= ruleStringLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAtomAccess().getStringLiteralParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleStringLiteral_in_ruleatom2039);
                    this_StringLiteral_2=ruleStringLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_StringLiteral_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:974:2: this_BoolLiteral_3= ruleBoolLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAtomAccess().getBoolLiteralParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleBoolLiteral_in_ruleatom2069);
                    this_BoolLiteral_3=ruleBoolLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_BoolLiteral_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:987:2: this_FunctionLiteral_4= ruleFunctionLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAtomAccess().getFunctionLiteralParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleFunctionLiteral_in_ruleatom2099);
                    this_FunctionLiteral_4=ruleFunctionLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_FunctionLiteral_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1000:2: this_Variable_5= ruleVariable
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAtomAccess().getVariableParserRuleCall_5()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleVariable_in_ruleatom2129);
                    this_Variable_5=ruleVariable();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Variable_5; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 7 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1013:2: this_Parenthesis_6= ruleParenthesis
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAtomAccess().getParenthesisParserRuleCall_6()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesis_in_ruleatom2159);
                    this_Parenthesis_6=ruleParenthesis();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Parenthesis_6; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 8 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1026:2: this_ProbabilityFunctionLiteral_7= ruleProbabilityFunctionLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAtomAccess().getProbabilityFunctionLiteralParserRuleCall_7()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleProbabilityFunctionLiteral_in_ruleatom2189);
                    this_ProbabilityFunctionLiteral_7=ruleProbabilityFunctionLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ProbabilityFunctionLiteral_7; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleatom"


    // $ANTLR start "entryRuleDoubleLiteral"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1045:1: entryRuleDoubleLiteral returns [EObject current=null] : iv_ruleDoubleLiteral= ruleDoubleLiteral EOF ;
    public final EObject entryRuleDoubleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDoubleLiteral = null;


        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1046:2: (iv_ruleDoubleLiteral= ruleDoubleLiteral EOF )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1047:2: iv_ruleDoubleLiteral= ruleDoubleLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDoubleLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleDoubleLiteral_in_entryRuleDoubleLiteral2224);
            iv_ruleDoubleLiteral=ruleDoubleLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDoubleLiteral; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDoubleLiteral2234); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDoubleLiteral"


    // $ANTLR start "ruleDoubleLiteral"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1054:1: ruleDoubleLiteral returns [EObject current=null] : ( ( (lv_value_0_0= RULE_DOUBLE ) ) (this_SQUARE_PAREN_L_1= RULE_SQUARE_PAREN_L ( (lv_unit_2_0= ruleUnit ) ) this_SQUARE_PAREN_R_3= RULE_SQUARE_PAREN_R )? ) ;
    public final EObject ruleDoubleLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        Token this_SQUARE_PAREN_L_1=null;
        Token this_SQUARE_PAREN_R_3=null;
        EObject lv_unit_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1057:28: ( ( ( (lv_value_0_0= RULE_DOUBLE ) ) (this_SQUARE_PAREN_L_1= RULE_SQUARE_PAREN_L ( (lv_unit_2_0= ruleUnit ) ) this_SQUARE_PAREN_R_3= RULE_SQUARE_PAREN_R )? ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1058:1: ( ( (lv_value_0_0= RULE_DOUBLE ) ) (this_SQUARE_PAREN_L_1= RULE_SQUARE_PAREN_L ( (lv_unit_2_0= ruleUnit ) ) this_SQUARE_PAREN_R_3= RULE_SQUARE_PAREN_R )? )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1058:1: ( ( (lv_value_0_0= RULE_DOUBLE ) ) (this_SQUARE_PAREN_L_1= RULE_SQUARE_PAREN_L ( (lv_unit_2_0= ruleUnit ) ) this_SQUARE_PAREN_R_3= RULE_SQUARE_PAREN_R )? )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1058:2: ( (lv_value_0_0= RULE_DOUBLE ) ) (this_SQUARE_PAREN_L_1= RULE_SQUARE_PAREN_L ( (lv_unit_2_0= ruleUnit ) ) this_SQUARE_PAREN_R_3= RULE_SQUARE_PAREN_R )?
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1058:2: ( (lv_value_0_0= RULE_DOUBLE ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1059:1: (lv_value_0_0= RULE_DOUBLE )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1059:1: (lv_value_0_0= RULE_DOUBLE )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1060:3: lv_value_0_0= RULE_DOUBLE
            {
            lv_value_0_0=(Token)match(input,RULE_DOUBLE,FollowSets000.FOLLOW_RULE_DOUBLE_in_ruleDoubleLiteral2276); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_0_0, grammarAccess.getDoubleLiteralAccess().getValueDOUBLETerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getDoubleLiteralRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_0_0, 
                      		"DOUBLE");
              	    
            }

            }


            }

            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1076:2: (this_SQUARE_PAREN_L_1= RULE_SQUARE_PAREN_L ( (lv_unit_2_0= ruleUnit ) ) this_SQUARE_PAREN_R_3= RULE_SQUARE_PAREN_R )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_SQUARE_PAREN_L) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1076:3: this_SQUARE_PAREN_L_1= RULE_SQUARE_PAREN_L ( (lv_unit_2_0= ruleUnit ) ) this_SQUARE_PAREN_R_3= RULE_SQUARE_PAREN_R
                    {
                    this_SQUARE_PAREN_L_1=(Token)match(input,RULE_SQUARE_PAREN_L,FollowSets000.FOLLOW_RULE_SQUARE_PAREN_L_in_ruleDoubleLiteral2293); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SQUARE_PAREN_L_1, grammarAccess.getDoubleLiteralAccess().getSQUARE_PAREN_LTerminalRuleCall_1_0()); 
                          
                    }
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1080:1: ( (lv_unit_2_0= ruleUnit ) )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1081:1: (lv_unit_2_0= ruleUnit )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1081:1: (lv_unit_2_0= ruleUnit )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1082:3: lv_unit_2_0= ruleUnit
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDoubleLiteralAccess().getUnitUnitParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnit_in_ruleDoubleLiteral2313);
                    lv_unit_2_0=ruleUnit();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDoubleLiteralRule());
                      	        }
                             		set(
                             			current, 
                             			"unit",
                              		lv_unit_2_0, 
                              		"Unit");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    this_SQUARE_PAREN_R_3=(Token)match(input,RULE_SQUARE_PAREN_R,FollowSets000.FOLLOW_RULE_SQUARE_PAREN_R_in_ruleDoubleLiteral2324); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SQUARE_PAREN_R_3, grammarAccess.getDoubleLiteralAccess().getSQUARE_PAREN_RTerminalRuleCall_1_2()); 
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDoubleLiteral"


    // $ANTLR start "entryRuleProbabilityFunctionLiteral"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1110:1: entryRuleProbabilityFunctionLiteral returns [EObject current=null] : iv_ruleProbabilityFunctionLiteral= ruleProbabilityFunctionLiteral EOF ;
    public final EObject entryRuleProbabilityFunctionLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProbabilityFunctionLiteral = null;


        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1111:2: (iv_ruleProbabilityFunctionLiteral= ruleProbabilityFunctionLiteral EOF )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1112:2: iv_ruleProbabilityFunctionLiteral= ruleProbabilityFunctionLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProbabilityFunctionLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleProbabilityFunctionLiteral_in_entryRuleProbabilityFunctionLiteral2361);
            iv_ruleProbabilityFunctionLiteral=ruleProbabilityFunctionLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProbabilityFunctionLiteral; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleProbabilityFunctionLiteral2371); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProbabilityFunctionLiteral"


    // $ANTLR start "ruleProbabilityFunctionLiteral"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1119:1: ruleProbabilityFunctionLiteral returns [EObject current=null] : ( (lv_function_ProbabilityFunctionLiteral_0_0= ruledefinition ) ) ;
    public final EObject ruleProbabilityFunctionLiteral() throws RecognitionException {
        EObject current = null;

        EObject lv_function_ProbabilityFunctionLiteral_0_0 = null;


         enterRule(); 
            
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1122:28: ( ( (lv_function_ProbabilityFunctionLiteral_0_0= ruledefinition ) ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1123:1: ( (lv_function_ProbabilityFunctionLiteral_0_0= ruledefinition ) )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1123:1: ( (lv_function_ProbabilityFunctionLiteral_0_0= ruledefinition ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1124:1: (lv_function_ProbabilityFunctionLiteral_0_0= ruledefinition )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1124:1: (lv_function_ProbabilityFunctionLiteral_0_0= ruledefinition )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1125:3: lv_function_ProbabilityFunctionLiteral_0_0= ruledefinition
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getProbabilityFunctionLiteralAccess().getFunction_ProbabilityFunctionLiteralDefinitionParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruledefinition_in_ruleProbabilityFunctionLiteral2416);
            lv_function_ProbabilityFunctionLiteral_0_0=ruledefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getProbabilityFunctionLiteralRule());
              	        }
                     		set(
                     			current, 
                     			"function_ProbabilityFunctionLiteral",
                      		lv_function_ProbabilityFunctionLiteral_0_0, 
                      		"definition");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProbabilityFunctionLiteral"


    // $ANTLR start "entryRuleParenthesis"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1149:1: entryRuleParenthesis returns [EObject current=null] : iv_ruleParenthesis= ruleParenthesis EOF ;
    public final EObject entryRuleParenthesis() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesis = null;


        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1150:2: (iv_ruleParenthesis= ruleParenthesis EOF )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1151:2: iv_ruleParenthesis= ruleParenthesis EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParenthesisRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParenthesis_in_entryRuleParenthesis2451);
            iv_ruleParenthesis=ruleParenthesis();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParenthesis; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParenthesis2461); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParenthesis"


    // $ANTLR start "ruleParenthesis"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1158:1: ruleParenthesis returns [EObject current=null] : (this_LPAREN_0= RULE_LPAREN ( (lv_innerExpression_1_0= ruleifelseExpr ) ) this_RPAREN_2= RULE_RPAREN ) ;
    public final EObject ruleParenthesis() throws RecognitionException {
        EObject current = null;

        Token this_LPAREN_0=null;
        Token this_RPAREN_2=null;
        EObject lv_innerExpression_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1161:28: ( (this_LPAREN_0= RULE_LPAREN ( (lv_innerExpression_1_0= ruleifelseExpr ) ) this_RPAREN_2= RULE_RPAREN ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1162:1: (this_LPAREN_0= RULE_LPAREN ( (lv_innerExpression_1_0= ruleifelseExpr ) ) this_RPAREN_2= RULE_RPAREN )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1162:1: (this_LPAREN_0= RULE_LPAREN ( (lv_innerExpression_1_0= ruleifelseExpr ) ) this_RPAREN_2= RULE_RPAREN )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1162:2: this_LPAREN_0= RULE_LPAREN ( (lv_innerExpression_1_0= ruleifelseExpr ) ) this_RPAREN_2= RULE_RPAREN
            {
            this_LPAREN_0=(Token)match(input,RULE_LPAREN,FollowSets000.FOLLOW_RULE_LPAREN_in_ruleParenthesis2497); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_LPAREN_0, grammarAccess.getParenthesisAccess().getLPARENTerminalRuleCall_0()); 
                  
            }
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1166:1: ( (lv_innerExpression_1_0= ruleifelseExpr ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1167:1: (lv_innerExpression_1_0= ruleifelseExpr )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1167:1: (lv_innerExpression_1_0= ruleifelseExpr )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1168:3: lv_innerExpression_1_0= ruleifelseExpr
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParenthesisAccess().getInnerExpressionIfelseExprParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleifelseExpr_in_ruleParenthesis2517);
            lv_innerExpression_1_0=ruleifelseExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getParenthesisRule());
              	        }
                     		set(
                     			current, 
                     			"innerExpression",
                      		lv_innerExpression_1_0, 
                      		"ifelseExpr");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            this_RPAREN_2=(Token)match(input,RULE_RPAREN,FollowSets000.FOLLOW_RULE_RPAREN_in_ruleParenthesis2528); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_RPAREN_2, grammarAccess.getParenthesisAccess().getRPARENTerminalRuleCall_2()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParenthesis"


    // $ANTLR start "entryRuleFunctionLiteral"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1196:1: entryRuleFunctionLiteral returns [EObject current=null] : iv_ruleFunctionLiteral= ruleFunctionLiteral EOF ;
    public final EObject entryRuleFunctionLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionLiteral = null;


        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1197:2: (iv_ruleFunctionLiteral= ruleFunctionLiteral EOF )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1198:2: iv_ruleFunctionLiteral= ruleFunctionLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFunctionLiteral_in_entryRuleFunctionLiteral2563);
            iv_ruleFunctionLiteral=ruleFunctionLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunctionLiteral; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFunctionLiteral2573); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionLiteral"


    // $ANTLR start "ruleFunctionLiteral"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1205:1: ruleFunctionLiteral returns [EObject current=null] : ( ( (lv_id_0_0= RULE_ID ) ) this_LPAREN_1= RULE_LPAREN ( ( (lv_parameters_FunctionLiteral_2_0= ruleboolAndExpr ) ) (this_COLON_3= RULE_COLON ( (lv_parameters_FunctionLiteral_4_0= ruleboolAndExpr ) ) )* )? this_RPAREN_5= RULE_RPAREN ) ;
    public final EObject ruleFunctionLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;
        Token this_LPAREN_1=null;
        Token this_COLON_3=null;
        Token this_RPAREN_5=null;
        EObject lv_parameters_FunctionLiteral_2_0 = null;

        EObject lv_parameters_FunctionLiteral_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1208:28: ( ( ( (lv_id_0_0= RULE_ID ) ) this_LPAREN_1= RULE_LPAREN ( ( (lv_parameters_FunctionLiteral_2_0= ruleboolAndExpr ) ) (this_COLON_3= RULE_COLON ( (lv_parameters_FunctionLiteral_4_0= ruleboolAndExpr ) ) )* )? this_RPAREN_5= RULE_RPAREN ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1209:1: ( ( (lv_id_0_0= RULE_ID ) ) this_LPAREN_1= RULE_LPAREN ( ( (lv_parameters_FunctionLiteral_2_0= ruleboolAndExpr ) ) (this_COLON_3= RULE_COLON ( (lv_parameters_FunctionLiteral_4_0= ruleboolAndExpr ) ) )* )? this_RPAREN_5= RULE_RPAREN )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1209:1: ( ( (lv_id_0_0= RULE_ID ) ) this_LPAREN_1= RULE_LPAREN ( ( (lv_parameters_FunctionLiteral_2_0= ruleboolAndExpr ) ) (this_COLON_3= RULE_COLON ( (lv_parameters_FunctionLiteral_4_0= ruleboolAndExpr ) ) )* )? this_RPAREN_5= RULE_RPAREN )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1209:2: ( (lv_id_0_0= RULE_ID ) ) this_LPAREN_1= RULE_LPAREN ( ( (lv_parameters_FunctionLiteral_2_0= ruleboolAndExpr ) ) (this_COLON_3= RULE_COLON ( (lv_parameters_FunctionLiteral_4_0= ruleboolAndExpr ) ) )* )? this_RPAREN_5= RULE_RPAREN
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1209:2: ( (lv_id_0_0= RULE_ID ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1210:1: (lv_id_0_0= RULE_ID )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1210:1: (lv_id_0_0= RULE_ID )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1211:3: lv_id_0_0= RULE_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFunctionLiteral2615); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_id_0_0, grammarAccess.getFunctionLiteralAccess().getIdIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getFunctionLiteralRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"id",
                      		lv_id_0_0, 
                      		"ID");
              	    
            }

            }


            }

            this_LPAREN_1=(Token)match(input,RULE_LPAREN,FollowSets000.FOLLOW_RULE_LPAREN_in_ruleFunctionLiteral2631); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_LPAREN_1, grammarAccess.getFunctionLiteralAccess().getLPARENTerminalRuleCall_1()); 
                  
            }
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1231:1: ( ( (lv_parameters_FunctionLiteral_2_0= ruleboolAndExpr ) ) (this_COLON_3= RULE_COLON ( (lv_parameters_FunctionLiteral_4_0= ruleboolAndExpr ) ) )* )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>=RULE_NOT && LA12_0<=RULE_DOUBLE)||LA12_0==RULE_LPAREN||LA12_0==RULE_ID||(LA12_0>=RULE_BOOLEAN_KEYWORDS && LA12_0<=RULE_ENUMPMF)||LA12_0==RULE_BOOLPMF||LA12_0==31) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1231:2: ( (lv_parameters_FunctionLiteral_2_0= ruleboolAndExpr ) ) (this_COLON_3= RULE_COLON ( (lv_parameters_FunctionLiteral_4_0= ruleboolAndExpr ) ) )*
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1231:2: ( (lv_parameters_FunctionLiteral_2_0= ruleboolAndExpr ) )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1232:1: (lv_parameters_FunctionLiteral_2_0= ruleboolAndExpr )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1232:1: (lv_parameters_FunctionLiteral_2_0= ruleboolAndExpr )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1233:3: lv_parameters_FunctionLiteral_2_0= ruleboolAndExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFunctionLiteralAccess().getParameters_FunctionLiteralBoolAndExprParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleboolAndExpr_in_ruleFunctionLiteral2652);
                    lv_parameters_FunctionLiteral_2_0=ruleboolAndExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFunctionLiteralRule());
                      	        }
                             		add(
                             			current, 
                             			"parameters_FunctionLiteral",
                              		lv_parameters_FunctionLiteral_2_0, 
                              		"boolAndExpr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1249:2: (this_COLON_3= RULE_COLON ( (lv_parameters_FunctionLiteral_4_0= ruleboolAndExpr ) ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==RULE_COLON) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1249:3: this_COLON_3= RULE_COLON ( (lv_parameters_FunctionLiteral_4_0= ruleboolAndExpr ) )
                    	    {
                    	    this_COLON_3=(Token)match(input,RULE_COLON,FollowSets000.FOLLOW_RULE_COLON_in_ruleFunctionLiteral2664); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_COLON_3, grammarAccess.getFunctionLiteralAccess().getCOLONTerminalRuleCall_2_1_0()); 
                    	          
                    	    }
                    	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1253:1: ( (lv_parameters_FunctionLiteral_4_0= ruleboolAndExpr ) )
                    	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1254:1: (lv_parameters_FunctionLiteral_4_0= ruleboolAndExpr )
                    	    {
                    	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1254:1: (lv_parameters_FunctionLiteral_4_0= ruleboolAndExpr )
                    	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1255:3: lv_parameters_FunctionLiteral_4_0= ruleboolAndExpr
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getFunctionLiteralAccess().getParameters_FunctionLiteralBoolAndExprParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleboolAndExpr_in_ruleFunctionLiteral2684);
                    	    lv_parameters_FunctionLiteral_4_0=ruleboolAndExpr();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getFunctionLiteralRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"parameters_FunctionLiteral",
                    	              		lv_parameters_FunctionLiteral_4_0, 
                    	              		"boolAndExpr");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    }
                    break;

            }

            this_RPAREN_5=(Token)match(input,RULE_RPAREN,FollowSets000.FOLLOW_RULE_RPAREN_in_ruleFunctionLiteral2699); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_RPAREN_5, grammarAccess.getFunctionLiteralAccess().getRPARENTerminalRuleCall_3()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionLiteral"


    // $ANTLR start "entryRuleAbstractNamedReference"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1283:1: entryRuleAbstractNamedReference returns [EObject current=null] : iv_ruleAbstractNamedReference= ruleAbstractNamedReference EOF ;
    public final EObject entryRuleAbstractNamedReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractNamedReference = null;


        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1284:2: (iv_ruleAbstractNamedReference= ruleAbstractNamedReference EOF )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1285:2: iv_ruleAbstractNamedReference= ruleAbstractNamedReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAbstractNamedReferenceRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAbstractNamedReference_in_entryRuleAbstractNamedReference2734);
            iv_ruleAbstractNamedReference=ruleAbstractNamedReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAbstractNamedReference; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractNamedReference2744); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAbstractNamedReference"


    // $ANTLR start "ruleAbstractNamedReference"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1292:1: ruleAbstractNamedReference returns [EObject current=null] : (this_VariableReference_0= ruleVariableReference | this_NamespaceReference_1= ruleNamespaceReference ) ;
    public final EObject ruleAbstractNamedReference() throws RecognitionException {
        EObject current = null;

        EObject this_VariableReference_0 = null;

        EObject this_NamespaceReference_1 = null;


         enterRule(); 
            
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1295:28: ( (this_VariableReference_0= ruleVariableReference | this_NamespaceReference_1= ruleNamespaceReference ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1296:1: (this_VariableReference_0= ruleVariableReference | this_NamespaceReference_1= ruleNamespaceReference )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1296:1: (this_VariableReference_0= ruleVariableReference | this_NamespaceReference_1= ruleNamespaceReference )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID) ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==RULE_DOT) ) {
                    alt13=2;
                }
                else if ( (LA13_1==EOF) ) {
                    alt13=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1297:2: this_VariableReference_0= ruleVariableReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAbstractNamedReferenceAccess().getVariableReferenceParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleVariableReference_in_ruleAbstractNamedReference2794);
                    this_VariableReference_0=ruleVariableReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_VariableReference_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1310:2: this_NamespaceReference_1= ruleNamespaceReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAbstractNamedReferenceAccess().getNamespaceReferenceParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNamespaceReference_in_ruleAbstractNamedReference2824);
                    this_NamespaceReference_1=ruleNamespaceReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_NamespaceReference_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbstractNamedReference"


    // $ANTLR start "entryRuleVariableReference"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1329:1: entryRuleVariableReference returns [EObject current=null] : iv_ruleVariableReference= ruleVariableReference EOF ;
    public final EObject entryRuleVariableReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableReference = null;


        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1330:2: (iv_ruleVariableReference= ruleVariableReference EOF )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1331:2: iv_ruleVariableReference= ruleVariableReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableReferenceRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVariableReference_in_entryRuleVariableReference2859);
            iv_ruleVariableReference=ruleVariableReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariableReference; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVariableReference2869); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableReference"


    // $ANTLR start "ruleVariableReference"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1338:1: ruleVariableReference returns [EObject current=null] : ( (lv_referenceName_0_0= RULE_ID ) ) ;
    public final EObject ruleVariableReference() throws RecognitionException {
        EObject current = null;

        Token lv_referenceName_0_0=null;

         enterRule(); 
            
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1341:28: ( ( (lv_referenceName_0_0= RULE_ID ) ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1342:1: ( (lv_referenceName_0_0= RULE_ID ) )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1342:1: ( (lv_referenceName_0_0= RULE_ID ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1343:1: (lv_referenceName_0_0= RULE_ID )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1343:1: (lv_referenceName_0_0= RULE_ID )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1344:3: lv_referenceName_0_0= RULE_ID
            {
            lv_referenceName_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleVariableReference2910); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_referenceName_0_0, grammarAccess.getVariableReferenceAccess().getReferenceNameIDTerminalRuleCall_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getVariableReferenceRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"referenceName",
                      		lv_referenceName_0_0, 
                      		"ID");
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableReference"


    // $ANTLR start "entryRuleNamespaceReference"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1368:1: entryRuleNamespaceReference returns [EObject current=null] : iv_ruleNamespaceReference= ruleNamespaceReference EOF ;
    public final EObject entryRuleNamespaceReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamespaceReference = null;


        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1369:2: (iv_ruleNamespaceReference= ruleNamespaceReference EOF )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1370:2: iv_ruleNamespaceReference= ruleNamespaceReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNamespaceReferenceRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNamespaceReference_in_entryRuleNamespaceReference2950);
            iv_ruleNamespaceReference=ruleNamespaceReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNamespaceReference; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNamespaceReference2960); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNamespaceReference"


    // $ANTLR start "ruleNamespaceReference"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1377:1: ruleNamespaceReference returns [EObject current=null] : ( ( (lv_referenceName_0_0= RULE_ID ) ) this_DOT_1= RULE_DOT ( (lv_innerReference_NamespaceReference_2_0= ruleAbstractNamedReference ) ) ) ;
    public final EObject ruleNamespaceReference() throws RecognitionException {
        EObject current = null;

        Token lv_referenceName_0_0=null;
        Token this_DOT_1=null;
        EObject lv_innerReference_NamespaceReference_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1380:28: ( ( ( (lv_referenceName_0_0= RULE_ID ) ) this_DOT_1= RULE_DOT ( (lv_innerReference_NamespaceReference_2_0= ruleAbstractNamedReference ) ) ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1381:1: ( ( (lv_referenceName_0_0= RULE_ID ) ) this_DOT_1= RULE_DOT ( (lv_innerReference_NamespaceReference_2_0= ruleAbstractNamedReference ) ) )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1381:1: ( ( (lv_referenceName_0_0= RULE_ID ) ) this_DOT_1= RULE_DOT ( (lv_innerReference_NamespaceReference_2_0= ruleAbstractNamedReference ) ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1381:2: ( (lv_referenceName_0_0= RULE_ID ) ) this_DOT_1= RULE_DOT ( (lv_innerReference_NamespaceReference_2_0= ruleAbstractNamedReference ) )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1381:2: ( (lv_referenceName_0_0= RULE_ID ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1382:1: (lv_referenceName_0_0= RULE_ID )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1382:1: (lv_referenceName_0_0= RULE_ID )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1383:3: lv_referenceName_0_0= RULE_ID
            {
            lv_referenceName_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNamespaceReference3002); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_referenceName_0_0, grammarAccess.getNamespaceReferenceAccess().getReferenceNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getNamespaceReferenceRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"referenceName",
                      		lv_referenceName_0_0, 
                      		"ID");
              	    
            }

            }


            }

            this_DOT_1=(Token)match(input,RULE_DOT,FollowSets000.FOLLOW_RULE_DOT_in_ruleNamespaceReference3018); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_DOT_1, grammarAccess.getNamespaceReferenceAccess().getDOTTerminalRuleCall_1()); 
                  
            }
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1403:1: ( (lv_innerReference_NamespaceReference_2_0= ruleAbstractNamedReference ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1404:1: (lv_innerReference_NamespaceReference_2_0= ruleAbstractNamedReference )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1404:1: (lv_innerReference_NamespaceReference_2_0= ruleAbstractNamedReference )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1405:3: lv_innerReference_NamespaceReference_2_0= ruleAbstractNamedReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNamespaceReferenceAccess().getInnerReference_NamespaceReferenceAbstractNamedReferenceParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleAbstractNamedReference_in_ruleNamespaceReference3038);
            lv_innerReference_NamespaceReference_2_0=ruleAbstractNamedReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNamespaceReferenceRule());
              	        }
                     		set(
                     			current, 
                     			"innerReference_NamespaceReference",
                      		lv_innerReference_NamespaceReference_2_0, 
                      		"AbstractNamedReference");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNamespaceReference"


    // $ANTLR start "entryRuleBoolLiteral"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1429:1: entryRuleBoolLiteral returns [EObject current=null] : iv_ruleBoolLiteral= ruleBoolLiteral EOF ;
    public final EObject entryRuleBoolLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolLiteral = null;


        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1430:2: (iv_ruleBoolLiteral= ruleBoolLiteral EOF )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1431:2: iv_ruleBoolLiteral= ruleBoolLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBoolLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBoolLiteral_in_entryRuleBoolLiteral3074);
            iv_ruleBoolLiteral=ruleBoolLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBoolLiteral; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBoolLiteral3084); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBoolLiteral"


    // $ANTLR start "ruleBoolLiteral"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1438:1: ruleBoolLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_BOOLEAN_KEYWORDS ) ) ;
    public final EObject ruleBoolLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1441:28: ( ( (lv_value_0_0= RULE_BOOLEAN_KEYWORDS ) ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1442:1: ( (lv_value_0_0= RULE_BOOLEAN_KEYWORDS ) )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1442:1: ( (lv_value_0_0= RULE_BOOLEAN_KEYWORDS ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1443:1: (lv_value_0_0= RULE_BOOLEAN_KEYWORDS )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1443:1: (lv_value_0_0= RULE_BOOLEAN_KEYWORDS )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1444:3: lv_value_0_0= RULE_BOOLEAN_KEYWORDS
            {
            lv_value_0_0=(Token)match(input,RULE_BOOLEAN_KEYWORDS,FollowSets000.FOLLOW_RULE_BOOLEAN_KEYWORDS_in_ruleBoolLiteral3125); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_0_0, grammarAccess.getBoolLiteralAccess().getValueBOOLEAN_KEYWORDSTerminalRuleCall_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getBoolLiteralRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_0_0, 
                      		"BOOLEAN_KEYWORDS");
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBoolLiteral"


    // $ANTLR start "entryRuleStringLiteral"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1468:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1469:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1470:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral3165);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteral; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStringLiteral3175); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringLiteral"


    // $ANTLR start "ruleStringLiteral"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1477:1: ruleStringLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1480:28: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1481:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1481:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1482:1: (lv_value_0_0= RULE_STRING )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1482:1: (lv_value_0_0= RULE_STRING )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1483:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleStringLiteral3216); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_0_0, grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getStringLiteralRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_0_0, 
                      		"STRING");
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringLiteral"


    // $ANTLR start "entryRuleIntLiteral"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1507:1: entryRuleIntLiteral returns [EObject current=null] : iv_ruleIntLiteral= ruleIntLiteral EOF ;
    public final EObject entryRuleIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntLiteral = null;


        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1508:2: (iv_ruleIntLiteral= ruleIntLiteral EOF )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1509:2: iv_ruleIntLiteral= ruleIntLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIntLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral3256);
            iv_ruleIntLiteral=ruleIntLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIntLiteral; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIntLiteral3266); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntLiteral"


    // $ANTLR start "ruleIntLiteral"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1516:1: ruleIntLiteral returns [EObject current=null] : ( ( (lv_value_0_0= RULE_DECINT ) ) (this_SQUARE_PAREN_L_1= RULE_SQUARE_PAREN_L ( (lv_unit_2_0= ruleUnit ) ) this_SQUARE_PAREN_R_3= RULE_SQUARE_PAREN_R )? ) ;
    public final EObject ruleIntLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        Token this_SQUARE_PAREN_L_1=null;
        Token this_SQUARE_PAREN_R_3=null;
        EObject lv_unit_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1519:28: ( ( ( (lv_value_0_0= RULE_DECINT ) ) (this_SQUARE_PAREN_L_1= RULE_SQUARE_PAREN_L ( (lv_unit_2_0= ruleUnit ) ) this_SQUARE_PAREN_R_3= RULE_SQUARE_PAREN_R )? ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1520:1: ( ( (lv_value_0_0= RULE_DECINT ) ) (this_SQUARE_PAREN_L_1= RULE_SQUARE_PAREN_L ( (lv_unit_2_0= ruleUnit ) ) this_SQUARE_PAREN_R_3= RULE_SQUARE_PAREN_R )? )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1520:1: ( ( (lv_value_0_0= RULE_DECINT ) ) (this_SQUARE_PAREN_L_1= RULE_SQUARE_PAREN_L ( (lv_unit_2_0= ruleUnit ) ) this_SQUARE_PAREN_R_3= RULE_SQUARE_PAREN_R )? )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1520:2: ( (lv_value_0_0= RULE_DECINT ) ) (this_SQUARE_PAREN_L_1= RULE_SQUARE_PAREN_L ( (lv_unit_2_0= ruleUnit ) ) this_SQUARE_PAREN_R_3= RULE_SQUARE_PAREN_R )?
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1520:2: ( (lv_value_0_0= RULE_DECINT ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1521:1: (lv_value_0_0= RULE_DECINT )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1521:1: (lv_value_0_0= RULE_DECINT )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1522:3: lv_value_0_0= RULE_DECINT
            {
            lv_value_0_0=(Token)match(input,RULE_DECINT,FollowSets000.FOLLOW_RULE_DECINT_in_ruleIntLiteral3308); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_0_0, grammarAccess.getIntLiteralAccess().getValueDECINTTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getIntLiteralRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_0_0, 
                      		"DECINT");
              	    
            }

            }


            }

            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1538:2: (this_SQUARE_PAREN_L_1= RULE_SQUARE_PAREN_L ( (lv_unit_2_0= ruleUnit ) ) this_SQUARE_PAREN_R_3= RULE_SQUARE_PAREN_R )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_SQUARE_PAREN_L) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1538:3: this_SQUARE_PAREN_L_1= RULE_SQUARE_PAREN_L ( (lv_unit_2_0= ruleUnit ) ) this_SQUARE_PAREN_R_3= RULE_SQUARE_PAREN_R
                    {
                    this_SQUARE_PAREN_L_1=(Token)match(input,RULE_SQUARE_PAREN_L,FollowSets000.FOLLOW_RULE_SQUARE_PAREN_L_in_ruleIntLiteral3325); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SQUARE_PAREN_L_1, grammarAccess.getIntLiteralAccess().getSQUARE_PAREN_LTerminalRuleCall_1_0()); 
                          
                    }
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1542:1: ( (lv_unit_2_0= ruleUnit ) )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1543:1: (lv_unit_2_0= ruleUnit )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1543:1: (lv_unit_2_0= ruleUnit )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1544:3: lv_unit_2_0= ruleUnit
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIntLiteralAccess().getUnitUnitParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnit_in_ruleIntLiteral3345);
                    lv_unit_2_0=ruleUnit();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getIntLiteralRule());
                      	        }
                             		set(
                             			current, 
                             			"unit",
                              		lv_unit_2_0, 
                              		"Unit");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    this_SQUARE_PAREN_R_3=(Token)match(input,RULE_SQUARE_PAREN_R,FollowSets000.FOLLOW_RULE_SQUARE_PAREN_R_in_ruleIntLiteral3356); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SQUARE_PAREN_R_3, grammarAccess.getIntLiteralAccess().getSQUARE_PAREN_RTerminalRuleCall_1_2()); 
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntLiteral"


    // $ANTLR start "entryRuleUnit"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1572:1: entryRuleUnit returns [EObject current=null] : iv_ruleUnit= ruleUnit EOF ;
    public final EObject entryRuleUnit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnit = null;


        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1573:2: (iv_ruleUnit= ruleUnit EOF )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1574:2: iv_ruleUnit= ruleUnit EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnitRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnit_in_entryRuleUnit3393);
            iv_ruleUnit=ruleUnit();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnit; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnit3403); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnit"


    // $ANTLR start "ruleUnit"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1581:1: ruleUnit returns [EObject current=null] : (this_unitMulti_0= ruleunitMulti | this_unitDiv_1= ruleunitDiv | this_BaseUnit_2= ruleBaseUnit ) ;
    public final EObject ruleUnit() throws RecognitionException {
        EObject current = null;

        EObject this_unitMulti_0 = null;

        EObject this_unitDiv_1 = null;

        EObject this_BaseUnit_2 = null;


         enterRule(); 
            
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1584:28: ( (this_unitMulti_0= ruleunitMulti | this_unitDiv_1= ruleunitDiv | this_BaseUnit_2= ruleBaseUnit ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1585:1: (this_unitMulti_0= ruleunitMulti | this_unitDiv_1= ruleunitDiv | this_BaseUnit_2= ruleBaseUnit )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1585:1: (this_unitMulti_0= ruleunitMulti | this_unitDiv_1= ruleunitDiv | this_BaseUnit_2= ruleBaseUnit )
            int alt15=3;
            alt15 = dfa15.predict(input);
            switch (alt15) {
                case 1 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1586:2: this_unitMulti_0= ruleunitMulti
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getUnitAccess().getUnitMultiParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleunitMulti_in_ruleUnit3453);
                    this_unitMulti_0=ruleunitMulti();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_unitMulti_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1599:2: this_unitDiv_1= ruleunitDiv
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getUnitAccess().getUnitDivParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleunitDiv_in_ruleUnit3483);
                    this_unitDiv_1=ruleunitDiv();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_unitDiv_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1612:2: this_BaseUnit_2= ruleBaseUnit
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getUnitAccess().getBaseUnitParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleBaseUnit_in_ruleUnit3513);
                    this_BaseUnit_2=ruleBaseUnit();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_BaseUnit_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnit"


    // $ANTLR start "entryRuleunitDiv"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1631:1: entryRuleunitDiv returns [EObject current=null] : iv_ruleunitDiv= ruleunitDiv EOF ;
    public final EObject entryRuleunitDiv() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleunitDiv = null;


        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1632:2: (iv_ruleunitDiv= ruleunitDiv EOF )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1633:2: iv_ruleunitDiv= ruleunitDiv EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnitDivRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleunitDiv_in_entryRuleunitDiv3548);
            iv_ruleunitDiv=ruleunitDiv();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleunitDiv; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleunitDiv3558); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleunitDiv"


    // $ANTLR start "ruleunitDiv"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1640:1: ruleunitDiv returns [EObject current=null] : (this_unitPow_0= ruleunitPow ( () otherlv_2= '/' ( (lv_divisor_3_0= ruleUnit ) ) )? ) ;
    public final EObject ruleunitDiv() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_unitPow_0 = null;

        EObject lv_divisor_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1643:28: ( (this_unitPow_0= ruleunitPow ( () otherlv_2= '/' ( (lv_divisor_3_0= ruleUnit ) ) )? ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1644:1: (this_unitPow_0= ruleunitPow ( () otherlv_2= '/' ( (lv_divisor_3_0= ruleUnit ) ) )? )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1644:1: (this_unitPow_0= ruleunitPow ( () otherlv_2= '/' ( (lv_divisor_3_0= ruleUnit ) ) )? )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1645:2: this_unitPow_0= ruleunitPow ( () otherlv_2= '/' ( (lv_divisor_3_0= ruleUnit ) ) )?
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getUnitDivAccess().getUnitPowParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleunitPow_in_ruleunitDiv3608);
            this_unitPow_0=ruleunitPow();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_unitPow_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1656:1: ( () otherlv_2= '/' ( (lv_divisor_3_0= ruleUnit ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==32) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1656:2: () otherlv_2= '/' ( (lv_divisor_3_0= ruleUnit ) )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1656:2: ()
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1657:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getUnitDivAccess().getUnitDivisionDividendAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_2=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleunitDiv3632); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getUnitDivAccess().getSolidusKeyword_1_1());
                          
                    }
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1669:1: ( (lv_divisor_3_0= ruleUnit ) )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1670:1: (lv_divisor_3_0= ruleUnit )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1670:1: (lv_divisor_3_0= ruleUnit )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1671:3: lv_divisor_3_0= ruleUnit
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnitDivAccess().getDivisorUnitParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnit_in_ruleunitDiv3653);
                    lv_divisor_3_0=ruleUnit();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getUnitDivRule());
                      	        }
                             		set(
                             			current, 
                             			"divisor",
                              		lv_divisor_3_0, 
                              		"Unit");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleunitDiv"


    // $ANTLR start "entryRuleunitMulti"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1695:1: entryRuleunitMulti returns [EObject current=null] : iv_ruleunitMulti= ruleunitMulti EOF ;
    public final EObject entryRuleunitMulti() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleunitMulti = null;


        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1696:2: (iv_ruleunitMulti= ruleunitMulti EOF )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1697:2: iv_ruleunitMulti= ruleunitMulti EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnitMultiRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleunitMulti_in_entryRuleunitMulti3691);
            iv_ruleunitMulti=ruleunitMulti();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleunitMulti; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleunitMulti3701); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleunitMulti"


    // $ANTLR start "ruleunitMulti"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1704:1: ruleunitMulti returns [EObject current=null] : (this_unitPow_0= ruleunitPow ( () otherlv_2= '*' ( (lv_units_3_0= ruleUnit ) ) )* ) ;
    public final EObject ruleunitMulti() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_unitPow_0 = null;

        EObject lv_units_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1707:28: ( (this_unitPow_0= ruleunitPow ( () otherlv_2= '*' ( (lv_units_3_0= ruleUnit ) ) )* ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1708:1: (this_unitPow_0= ruleunitPow ( () otherlv_2= '*' ( (lv_units_3_0= ruleUnit ) ) )* )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1708:1: (this_unitPow_0= ruleunitPow ( () otherlv_2= '*' ( (lv_units_3_0= ruleUnit ) ) )* )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1709:2: this_unitPow_0= ruleunitPow ( () otherlv_2= '*' ( (lv_units_3_0= ruleUnit ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getUnitMultiAccess().getUnitPowParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleunitPow_in_ruleunitMulti3751);
            this_unitPow_0=ruleunitPow();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_unitPow_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1720:1: ( () otherlv_2= '*' ( (lv_units_3_0= ruleUnit ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==33) ) {
                    int LA17_2 = input.LA(2);

                    if ( (synpred25_InternalPCMStoEx()) ) {
                        alt17=1;
                    }


                }


                switch (alt17) {
            	case 1 :
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1720:2: () otherlv_2= '*' ( (lv_units_3_0= ruleUnit ) )
            	    {
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1720:2: ()
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1721:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndAdd(
            	                  grammarAccess.getUnitMultiAccess().getUnitMultiplicationUnitsAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleunitMulti3775); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getUnitMultiAccess().getAsteriskKeyword_1_1());
            	          
            	    }
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1733:1: ( (lv_units_3_0= ruleUnit ) )
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1734:1: (lv_units_3_0= ruleUnit )
            	    {
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1734:1: (lv_units_3_0= ruleUnit )
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1735:3: lv_units_3_0= ruleUnit
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getUnitMultiAccess().getUnitsUnitParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleUnit_in_ruleunitMulti3796);
            	    lv_units_3_0=ruleUnit();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getUnitMultiRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"units",
            	              		lv_units_3_0, 
            	              		"Unit");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleunitMulti"


    // $ANTLR start "entryRuleunitPow"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1759:1: entryRuleunitPow returns [EObject current=null] : iv_ruleunitPow= ruleunitPow EOF ;
    public final EObject entryRuleunitPow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleunitPow = null;


        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1760:2: (iv_ruleunitPow= ruleunitPow EOF )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1761:2: iv_ruleunitPow= ruleunitPow EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnitPowRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleunitPow_in_entryRuleunitPow3834);
            iv_ruleunitPow=ruleunitPow();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleunitPow; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleunitPow3844); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleunitPow"


    // $ANTLR start "ruleunitPow"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1768:1: ruleunitPow returns [EObject current=null] : ( (this_BaseUnit_0= ruleBaseUnit | (this_LPAREN_1= RULE_LPAREN (this_unitMulti_2= ruleunitMulti | this_unitDiv_3= ruleunitDiv ) this_RPAREN_4= RULE_RPAREN ) ) ( () this_POW_6= RULE_POW ( (lv_exponent_7_0= ruleSIGNED_INT ) ) )* ) ;
    public final EObject ruleunitPow() throws RecognitionException {
        EObject current = null;

        Token this_LPAREN_1=null;
        Token this_RPAREN_4=null;
        Token this_POW_6=null;
        EObject this_BaseUnit_0 = null;

        EObject this_unitMulti_2 = null;

        EObject this_unitDiv_3 = null;

        AntlrDatatypeRuleToken lv_exponent_7_0 = null;


         enterRule(); 
            
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1771:28: ( ( (this_BaseUnit_0= ruleBaseUnit | (this_LPAREN_1= RULE_LPAREN (this_unitMulti_2= ruleunitMulti | this_unitDiv_3= ruleunitDiv ) this_RPAREN_4= RULE_RPAREN ) ) ( () this_POW_6= RULE_POW ( (lv_exponent_7_0= ruleSIGNED_INT ) ) )* ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1772:1: ( (this_BaseUnit_0= ruleBaseUnit | (this_LPAREN_1= RULE_LPAREN (this_unitMulti_2= ruleunitMulti | this_unitDiv_3= ruleunitDiv ) this_RPAREN_4= RULE_RPAREN ) ) ( () this_POW_6= RULE_POW ( (lv_exponent_7_0= ruleSIGNED_INT ) ) )* )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1772:1: ( (this_BaseUnit_0= ruleBaseUnit | (this_LPAREN_1= RULE_LPAREN (this_unitMulti_2= ruleunitMulti | this_unitDiv_3= ruleunitDiv ) this_RPAREN_4= RULE_RPAREN ) ) ( () this_POW_6= RULE_POW ( (lv_exponent_7_0= ruleSIGNED_INT ) ) )* )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1772:2: (this_BaseUnit_0= ruleBaseUnit | (this_LPAREN_1= RULE_LPAREN (this_unitMulti_2= ruleunitMulti | this_unitDiv_3= ruleunitDiv ) this_RPAREN_4= RULE_RPAREN ) ) ( () this_POW_6= RULE_POW ( (lv_exponent_7_0= ruleSIGNED_INT ) ) )*
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1772:2: (this_BaseUnit_0= ruleBaseUnit | (this_LPAREN_1= RULE_LPAREN (this_unitMulti_2= ruleunitMulti | this_unitDiv_3= ruleunitDiv ) this_RPAREN_4= RULE_RPAREN ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=50 && LA19_0<=54)) ) {
                alt19=1;
            }
            else if ( (LA19_0==RULE_LPAREN) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1773:2: this_BaseUnit_0= ruleBaseUnit
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getUnitPowAccess().getBaseUnitParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleBaseUnit_in_ruleunitPow3895);
                    this_BaseUnit_0=ruleBaseUnit();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_BaseUnit_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1785:6: (this_LPAREN_1= RULE_LPAREN (this_unitMulti_2= ruleunitMulti | this_unitDiv_3= ruleunitDiv ) this_RPAREN_4= RULE_RPAREN )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1785:6: (this_LPAREN_1= RULE_LPAREN (this_unitMulti_2= ruleunitMulti | this_unitDiv_3= ruleunitDiv ) this_RPAREN_4= RULE_RPAREN )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1785:7: this_LPAREN_1= RULE_LPAREN (this_unitMulti_2= ruleunitMulti | this_unitDiv_3= ruleunitDiv ) this_RPAREN_4= RULE_RPAREN
                    {
                    this_LPAREN_1=(Token)match(input,RULE_LPAREN,FollowSets000.FOLLOW_RULE_LPAREN_in_ruleunitPow3912); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LPAREN_1, grammarAccess.getUnitPowAccess().getLPARENTerminalRuleCall_0_1_0()); 
                          
                    }
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1789:1: (this_unitMulti_2= ruleunitMulti | this_unitDiv_3= ruleunitDiv )
                    int alt18=2;
                    switch ( input.LA(1) ) {
                    case 50:
                        {
                        int LA18_1 = input.LA(2);

                        if ( (synpred27_InternalPCMStoEx()) ) {
                            alt18=1;
                        }
                        else if ( (true) ) {
                            alt18=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 18, 1, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 51:
                        {
                        int LA18_2 = input.LA(2);

                        if ( (synpred27_InternalPCMStoEx()) ) {
                            alt18=1;
                        }
                        else if ( (true) ) {
                            alt18=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 18, 2, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 52:
                        {
                        int LA18_3 = input.LA(2);

                        if ( (synpred27_InternalPCMStoEx()) ) {
                            alt18=1;
                        }
                        else if ( (true) ) {
                            alt18=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 18, 3, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 53:
                        {
                        int LA18_4 = input.LA(2);

                        if ( (synpred27_InternalPCMStoEx()) ) {
                            alt18=1;
                        }
                        else if ( (true) ) {
                            alt18=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 18, 4, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 54:
                        {
                        int LA18_5 = input.LA(2);

                        if ( (synpred27_InternalPCMStoEx()) ) {
                            alt18=1;
                        }
                        else if ( (true) ) {
                            alt18=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 18, 5, input);

                            throw nvae;
                        }
                        }
                        break;
                    case RULE_LPAREN:
                        {
                        int LA18_6 = input.LA(2);

                        if ( (synpred27_InternalPCMStoEx()) ) {
                            alt18=1;
                        }
                        else if ( (true) ) {
                            alt18=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 18, 6, input);

                            throw nvae;
                        }
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 18, 0, input);

                        throw nvae;
                    }

                    switch (alt18) {
                        case 1 :
                            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1790:2: this_unitMulti_2= ruleunitMulti
                            {
                            if ( state.backtracking==0 ) {
                               
                              	  /* */ 
                              	
                            }
                            if ( state.backtracking==0 ) {
                               
                                      newCompositeNode(grammarAccess.getUnitPowAccess().getUnitMultiParserRuleCall_0_1_1_0()); 
                                  
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleunitMulti_in_ruleunitPow3937);
                            this_unitMulti_2=ruleunitMulti();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                               
                                      current = this_unitMulti_2; 
                                      afterParserOrEnumRuleCall();
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1803:2: this_unitDiv_3= ruleunitDiv
                            {
                            if ( state.backtracking==0 ) {
                               
                              	  /* */ 
                              	
                            }
                            if ( state.backtracking==0 ) {
                               
                                      newCompositeNode(grammarAccess.getUnitPowAccess().getUnitDivParserRuleCall_0_1_1_1()); 
                                  
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleunitDiv_in_ruleunitPow3967);
                            this_unitDiv_3=ruleunitDiv();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                               
                                      current = this_unitDiv_3; 
                                      afterParserOrEnumRuleCall();
                                  
                            }

                            }
                            break;

                    }

                    this_RPAREN_4=(Token)match(input,RULE_RPAREN,FollowSets000.FOLLOW_RULE_RPAREN_in_ruleunitPow3978); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_RPAREN_4, grammarAccess.getUnitPowAccess().getRPARENTerminalRuleCall_0_1_2()); 
                          
                    }

                    }


                    }
                    break;

            }

            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1818:3: ( () this_POW_6= RULE_POW ( (lv_exponent_7_0= ruleSIGNED_INT ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_POW) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1818:4: () this_POW_6= RULE_POW ( (lv_exponent_7_0= ruleSIGNED_INT ) )
            	    {
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1818:4: ()
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1819:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getUnitPowAccess().getUnitPowerUnitAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    this_POW_6=(Token)match(input,RULE_POW,FollowSets000.FOLLOW_RULE_POW_in_ruleunitPow4003); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_POW_6, grammarAccess.getUnitPowAccess().getPOWTerminalRuleCall_1_1()); 
            	          
            	    }
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1831:1: ( (lv_exponent_7_0= ruleSIGNED_INT ) )
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1832:1: (lv_exponent_7_0= ruleSIGNED_INT )
            	    {
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1832:1: (lv_exponent_7_0= ruleSIGNED_INT )
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1833:3: lv_exponent_7_0= ruleSIGNED_INT
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getUnitPowAccess().getExponentSIGNED_INTParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleSIGNED_INT_in_ruleunitPow4023);
            	    lv_exponent_7_0=ruleSIGNED_INT();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getUnitPowRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"exponent",
            	              		lv_exponent_7_0, 
            	              		"SIGNED_INT");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleunitPow"


    // $ANTLR start "entryRuleBaseUnit"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1857:1: entryRuleBaseUnit returns [EObject current=null] : iv_ruleBaseUnit= ruleBaseUnit EOF ;
    public final EObject entryRuleBaseUnit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBaseUnit = null;


        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1858:2: (iv_ruleBaseUnit= ruleBaseUnit EOF )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1859:2: iv_ruleBaseUnit= ruleBaseUnit EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBaseUnitRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBaseUnit_in_entryRuleBaseUnit4061);
            iv_ruleBaseUnit=ruleBaseUnit();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBaseUnit; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBaseUnit4071); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBaseUnit"


    // $ANTLR start "ruleBaseUnit"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1866:1: ruleBaseUnit returns [EObject current=null] : ( (lv_name_0_0= ruleUnitNames ) ) ;
    public final EObject ruleBaseUnit() throws RecognitionException {
        EObject current = null;

        Enumerator lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1869:28: ( ( (lv_name_0_0= ruleUnitNames ) ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1870:1: ( (lv_name_0_0= ruleUnitNames ) )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1870:1: ( (lv_name_0_0= ruleUnitNames ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1871:1: (lv_name_0_0= ruleUnitNames )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1871:1: (lv_name_0_0= ruleUnitNames )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1872:3: lv_name_0_0= ruleUnitNames
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getBaseUnitAccess().getNameUnitNamesEnumRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnitNames_in_ruleBaseUnit4116);
            lv_name_0_0=ruleUnitNames();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getBaseUnitRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"UnitNames");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBaseUnit"


    // $ANTLR start "entryRuledefinition"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1896:1: entryRuledefinition returns [EObject current=null] : iv_ruledefinition= ruledefinition EOF ;
    public final EObject entryRuledefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruledefinition = null;


        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1897:2: (iv_ruledefinition= ruledefinition EOF )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1898:2: iv_ruledefinition= ruledefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDefinitionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruledefinition_in_entryRuledefinition4151);
            iv_ruledefinition=ruledefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruledefinition; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuledefinition4161); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuledefinition"


    // $ANTLR start "ruledefinition"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1905:1: ruledefinition returns [EObject current=null] : (this_ProbabilityMassFunction_0= ruleProbabilityMassFunction | this_ProbabilityDensityFunction_1= ruleProbabilityDensityFunction ) ;
    public final EObject ruledefinition() throws RecognitionException {
        EObject current = null;

        EObject this_ProbabilityMassFunction_0 = null;

        EObject this_ProbabilityDensityFunction_1 = null;


         enterRule(); 
            
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1908:28: ( (this_ProbabilityMassFunction_0= ruleProbabilityMassFunction | this_ProbabilityDensityFunction_1= ruleProbabilityDensityFunction ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1909:1: (this_ProbabilityMassFunction_0= ruleProbabilityMassFunction | this_ProbabilityDensityFunction_1= ruleProbabilityDensityFunction )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1909:1: (this_ProbabilityMassFunction_0= ruleProbabilityMassFunction | this_ProbabilityDensityFunction_1= ruleProbabilityDensityFunction )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=RULE_INTPMF && LA21_0<=RULE_ENUMPMF)||LA21_0==RULE_BOOLPMF) ) {
                alt21=1;
            }
            else if ( (LA21_0==RULE_DOUBLEPDF) ) {
                alt21=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1910:2: this_ProbabilityMassFunction_0= ruleProbabilityMassFunction
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getDefinitionAccess().getProbabilityMassFunctionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleProbabilityMassFunction_in_ruledefinition4211);
                    this_ProbabilityMassFunction_0=ruleProbabilityMassFunction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ProbabilityMassFunction_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1923:2: this_ProbabilityDensityFunction_1= ruleProbabilityDensityFunction
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getDefinitionAccess().getProbabilityDensityFunctionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleProbabilityDensityFunction_in_ruledefinition4241);
                    this_ProbabilityDensityFunction_1=ruleProbabilityDensityFunction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ProbabilityDensityFunction_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruledefinition"


    // $ANTLR start "entryRuleProbabilityDensityFunction"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1942:1: entryRuleProbabilityDensityFunction returns [EObject current=null] : iv_ruleProbabilityDensityFunction= ruleProbabilityDensityFunction EOF ;
    public final EObject entryRuleProbabilityDensityFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProbabilityDensityFunction = null;


        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1943:2: (iv_ruleProbabilityDensityFunction= ruleProbabilityDensityFunction EOF )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1944:2: iv_ruleProbabilityDensityFunction= ruleProbabilityDensityFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProbabilityDensityFunctionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleProbabilityDensityFunction_in_entryRuleProbabilityDensityFunction4276);
            iv_ruleProbabilityDensityFunction=ruleProbabilityDensityFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProbabilityDensityFunction; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleProbabilityDensityFunction4286); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProbabilityDensityFunction"


    // $ANTLR start "ruleProbabilityDensityFunction"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1951:1: ruleProbabilityDensityFunction returns [EObject current=null] : this_BoxedPDF_0= ruleBoxedPDF ;
    public final EObject ruleProbabilityDensityFunction() throws RecognitionException {
        EObject current = null;

        EObject this_BoxedPDF_0 = null;


         enterRule(); 
            
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1954:28: (this_BoxedPDF_0= ruleBoxedPDF )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1956:2: this_BoxedPDF_0= ruleBoxedPDF
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getProbabilityDensityFunctionAccess().getBoxedPDFParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleBoxedPDF_in_ruleProbabilityDensityFunction4335);
            this_BoxedPDF_0=ruleBoxedPDF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_BoxedPDF_0; 
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProbabilityDensityFunction"


    // $ANTLR start "entryRuleBoxedPDF"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1975:1: entryRuleBoxedPDF returns [EObject current=null] : iv_ruleBoxedPDF= ruleBoxedPDF EOF ;
    public final EObject entryRuleBoxedPDF() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoxedPDF = null;


        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1976:2: (iv_ruleBoxedPDF= ruleBoxedPDF EOF )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1977:2: iv_ruleBoxedPDF= ruleBoxedPDF EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBoxedPDFRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBoxedPDF_in_entryRuleBoxedPDF4369);
            iv_ruleBoxedPDF=ruleBoxedPDF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBoxedPDF; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBoxedPDF4379); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBoxedPDF"


    // $ANTLR start "ruleBoxedPDF"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1984:1: ruleBoxedPDF returns [EObject current=null] : (this_DOUBLEPDF_0= RULE_DOUBLEPDF this_SQUARE_PAREN_L_1= RULE_SQUARE_PAREN_L ( (lv_samples_2_0= rulereal_pdf_sample ) )+ this_SQUARE_PAREN_R_3= RULE_SQUARE_PAREN_R (this_SQUARE_PAREN_L_4= RULE_SQUARE_PAREN_L ( (lv_unit_5_0= ruleUnit ) ) this_SQUARE_PAREN_R_6= RULE_SQUARE_PAREN_R )? ) ;
    public final EObject ruleBoxedPDF() throws RecognitionException {
        EObject current = null;

        Token this_DOUBLEPDF_0=null;
        Token this_SQUARE_PAREN_L_1=null;
        Token this_SQUARE_PAREN_R_3=null;
        Token this_SQUARE_PAREN_L_4=null;
        Token this_SQUARE_PAREN_R_6=null;
        EObject lv_samples_2_0 = null;

        EObject lv_unit_5_0 = null;


         enterRule(); 
            
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1987:28: ( (this_DOUBLEPDF_0= RULE_DOUBLEPDF this_SQUARE_PAREN_L_1= RULE_SQUARE_PAREN_L ( (lv_samples_2_0= rulereal_pdf_sample ) )+ this_SQUARE_PAREN_R_3= RULE_SQUARE_PAREN_R (this_SQUARE_PAREN_L_4= RULE_SQUARE_PAREN_L ( (lv_unit_5_0= ruleUnit ) ) this_SQUARE_PAREN_R_6= RULE_SQUARE_PAREN_R )? ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1988:1: (this_DOUBLEPDF_0= RULE_DOUBLEPDF this_SQUARE_PAREN_L_1= RULE_SQUARE_PAREN_L ( (lv_samples_2_0= rulereal_pdf_sample ) )+ this_SQUARE_PAREN_R_3= RULE_SQUARE_PAREN_R (this_SQUARE_PAREN_L_4= RULE_SQUARE_PAREN_L ( (lv_unit_5_0= ruleUnit ) ) this_SQUARE_PAREN_R_6= RULE_SQUARE_PAREN_R )? )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1988:1: (this_DOUBLEPDF_0= RULE_DOUBLEPDF this_SQUARE_PAREN_L_1= RULE_SQUARE_PAREN_L ( (lv_samples_2_0= rulereal_pdf_sample ) )+ this_SQUARE_PAREN_R_3= RULE_SQUARE_PAREN_R (this_SQUARE_PAREN_L_4= RULE_SQUARE_PAREN_L ( (lv_unit_5_0= ruleUnit ) ) this_SQUARE_PAREN_R_6= RULE_SQUARE_PAREN_R )? )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1988:2: this_DOUBLEPDF_0= RULE_DOUBLEPDF this_SQUARE_PAREN_L_1= RULE_SQUARE_PAREN_L ( (lv_samples_2_0= rulereal_pdf_sample ) )+ this_SQUARE_PAREN_R_3= RULE_SQUARE_PAREN_R (this_SQUARE_PAREN_L_4= RULE_SQUARE_PAREN_L ( (lv_unit_5_0= ruleUnit ) ) this_SQUARE_PAREN_R_6= RULE_SQUARE_PAREN_R )?
            {
            this_DOUBLEPDF_0=(Token)match(input,RULE_DOUBLEPDF,FollowSets000.FOLLOW_RULE_DOUBLEPDF_in_ruleBoxedPDF4415); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_DOUBLEPDF_0, grammarAccess.getBoxedPDFAccess().getDOUBLEPDFTerminalRuleCall_0()); 
                  
            }
            this_SQUARE_PAREN_L_1=(Token)match(input,RULE_SQUARE_PAREN_L,FollowSets000.FOLLOW_RULE_SQUARE_PAREN_L_in_ruleBoxedPDF4425); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SQUARE_PAREN_L_1, grammarAccess.getBoxedPDFAccess().getSQUARE_PAREN_LTerminalRuleCall_1()); 
                  
            }
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1996:1: ( (lv_samples_2_0= rulereal_pdf_sample ) )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_LPAREN) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1997:1: (lv_samples_2_0= rulereal_pdf_sample )
            	    {
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1997:1: (lv_samples_2_0= rulereal_pdf_sample )
            	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1998:3: lv_samples_2_0= rulereal_pdf_sample
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getBoxedPDFAccess().getSamplesReal_pdf_sampleParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_rulereal_pdf_sample_in_ruleBoxedPDF4445);
            	    lv_samples_2_0=rulereal_pdf_sample();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getBoxedPDFRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"samples",
            	              		lv_samples_2_0, 
            	              		"real_pdf_sample");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt22 >= 1 ) break loop22;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(22, input);
                        throw eee;
                }
                cnt22++;
            } while (true);

            this_SQUARE_PAREN_R_3=(Token)match(input,RULE_SQUARE_PAREN_R,FollowSets000.FOLLOW_RULE_SQUARE_PAREN_R_in_ruleBoxedPDF4457); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SQUARE_PAREN_R_3, grammarAccess.getBoxedPDFAccess().getSQUARE_PAREN_RTerminalRuleCall_3()); 
                  
            }
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2018:1: (this_SQUARE_PAREN_L_4= RULE_SQUARE_PAREN_L ( (lv_unit_5_0= ruleUnit ) ) this_SQUARE_PAREN_R_6= RULE_SQUARE_PAREN_R )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_SQUARE_PAREN_L) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2018:2: this_SQUARE_PAREN_L_4= RULE_SQUARE_PAREN_L ( (lv_unit_5_0= ruleUnit ) ) this_SQUARE_PAREN_R_6= RULE_SQUARE_PAREN_R
                    {
                    this_SQUARE_PAREN_L_4=(Token)match(input,RULE_SQUARE_PAREN_L,FollowSets000.FOLLOW_RULE_SQUARE_PAREN_L_in_ruleBoxedPDF4468); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SQUARE_PAREN_L_4, grammarAccess.getBoxedPDFAccess().getSQUARE_PAREN_LTerminalRuleCall_4_0()); 
                          
                    }
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2022:1: ( (lv_unit_5_0= ruleUnit ) )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2023:1: (lv_unit_5_0= ruleUnit )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2023:1: (lv_unit_5_0= ruleUnit )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2024:3: lv_unit_5_0= ruleUnit
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getBoxedPDFAccess().getUnitUnitParserRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnit_in_ruleBoxedPDF4488);
                    lv_unit_5_0=ruleUnit();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getBoxedPDFRule());
                      	        }
                             		set(
                             			current, 
                             			"unit",
                              		lv_unit_5_0, 
                              		"Unit");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    this_SQUARE_PAREN_R_6=(Token)match(input,RULE_SQUARE_PAREN_R,FollowSets000.FOLLOW_RULE_SQUARE_PAREN_R_in_ruleBoxedPDF4499); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SQUARE_PAREN_R_6, grammarAccess.getBoxedPDFAccess().getSQUARE_PAREN_RTerminalRuleCall_4_2()); 
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBoxedPDF"


    // $ANTLR start "entryRuleProbabilityMassFunction"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2052:1: entryRuleProbabilityMassFunction returns [EObject current=null] : iv_ruleProbabilityMassFunction= ruleProbabilityMassFunction EOF ;
    public final EObject entryRuleProbabilityMassFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProbabilityMassFunction = null;


        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2053:2: (iv_ruleProbabilityMassFunction= ruleProbabilityMassFunction EOF )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2054:2: iv_ruleProbabilityMassFunction= ruleProbabilityMassFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProbabilityMassFunctionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleProbabilityMassFunction_in_entryRuleProbabilityMassFunction4536);
            iv_ruleProbabilityMassFunction=ruleProbabilityMassFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProbabilityMassFunction; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleProbabilityMassFunction4546); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProbabilityMassFunction"


    // $ANTLR start "ruleProbabilityMassFunction"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2061:1: ruleProbabilityMassFunction returns [EObject current=null] : ( (this_INTPMF_0= RULE_INTPMF this_SQUARE_PAREN_L_1= RULE_SQUARE_PAREN_L ( (lv_samples_2_0= rulenumeric_int_sample ) )+ this_SQUARE_PAREN_R_3= RULE_SQUARE_PAREN_R (this_SQUARE_PAREN_L_4= RULE_SQUARE_PAREN_L ( (lv_unit_5_0= ruleUnit ) ) this_SQUARE_PAREN_R_6= RULE_SQUARE_PAREN_R )? ) | (this_DOUBLEPMF_7= RULE_DOUBLEPMF this_SQUARE_PAREN_L_8= RULE_SQUARE_PAREN_L ( (lv_samples_9_0= rulenumeric_real_sample ) )+ this_SQUARE_PAREN_R_10= RULE_SQUARE_PAREN_R (this_SQUARE_PAREN_L_11= RULE_SQUARE_PAREN_L ( (lv_unit_12_0= ruleUnit ) ) this_SQUARE_PAREN_R_13= RULE_SQUARE_PAREN_R )? ) | (this_ENUMPMF_14= RULE_ENUMPMF (this_LPAREN_15= RULE_LPAREN ( (lv_orderedDomain_16_0= RULE_ORDERED_DEF ) ) this_RPAREN_17= RULE_RPAREN )? this_SQUARE_PAREN_L_18= RULE_SQUARE_PAREN_L ( (lv_samples_19_0= rulestringsample ) )+ this_SQUARE_PAREN_R_20= RULE_SQUARE_PAREN_R ) | (this_BOOLPMF_21= RULE_BOOLPMF (this_LPAREN_22= RULE_LPAREN ( (lv_orderedDomain_23_0= RULE_ORDERED_DEF ) ) this_RPAREN_24= RULE_RPAREN )? this_SQUARE_PAREN_L_25= RULE_SQUARE_PAREN_L ( (lv_samples_26_0= ruleboolsample ) )+ this_SQUARE_PAREN_R_27= RULE_SQUARE_PAREN_R ) ) ;
    public final EObject ruleProbabilityMassFunction() throws RecognitionException {
        EObject current = null;

        Token this_INTPMF_0=null;
        Token this_SQUARE_PAREN_L_1=null;
        Token this_SQUARE_PAREN_R_3=null;
        Token this_SQUARE_PAREN_L_4=null;
        Token this_SQUARE_PAREN_R_6=null;
        Token this_DOUBLEPMF_7=null;
        Token this_SQUARE_PAREN_L_8=null;
        Token this_SQUARE_PAREN_R_10=null;
        Token this_SQUARE_PAREN_L_11=null;
        Token this_SQUARE_PAREN_R_13=null;
        Token this_ENUMPMF_14=null;
        Token this_LPAREN_15=null;
        Token lv_orderedDomain_16_0=null;
        Token this_RPAREN_17=null;
        Token this_SQUARE_PAREN_L_18=null;
        Token this_SQUARE_PAREN_R_20=null;
        Token this_BOOLPMF_21=null;
        Token this_LPAREN_22=null;
        Token lv_orderedDomain_23_0=null;
        Token this_RPAREN_24=null;
        Token this_SQUARE_PAREN_L_25=null;
        Token this_SQUARE_PAREN_R_27=null;
        EObject lv_samples_2_0 = null;

        EObject lv_unit_5_0 = null;

        EObject lv_samples_9_0 = null;

        EObject lv_unit_12_0 = null;

        EObject lv_samples_19_0 = null;

        EObject lv_samples_26_0 = null;


         enterRule(); 
            
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2064:28: ( ( (this_INTPMF_0= RULE_INTPMF this_SQUARE_PAREN_L_1= RULE_SQUARE_PAREN_L ( (lv_samples_2_0= rulenumeric_int_sample ) )+ this_SQUARE_PAREN_R_3= RULE_SQUARE_PAREN_R (this_SQUARE_PAREN_L_4= RULE_SQUARE_PAREN_L ( (lv_unit_5_0= ruleUnit ) ) this_SQUARE_PAREN_R_6= RULE_SQUARE_PAREN_R )? ) | (this_DOUBLEPMF_7= RULE_DOUBLEPMF this_SQUARE_PAREN_L_8= RULE_SQUARE_PAREN_L ( (lv_samples_9_0= rulenumeric_real_sample ) )+ this_SQUARE_PAREN_R_10= RULE_SQUARE_PAREN_R (this_SQUARE_PAREN_L_11= RULE_SQUARE_PAREN_L ( (lv_unit_12_0= ruleUnit ) ) this_SQUARE_PAREN_R_13= RULE_SQUARE_PAREN_R )? ) | (this_ENUMPMF_14= RULE_ENUMPMF (this_LPAREN_15= RULE_LPAREN ( (lv_orderedDomain_16_0= RULE_ORDERED_DEF ) ) this_RPAREN_17= RULE_RPAREN )? this_SQUARE_PAREN_L_18= RULE_SQUARE_PAREN_L ( (lv_samples_19_0= rulestringsample ) )+ this_SQUARE_PAREN_R_20= RULE_SQUARE_PAREN_R ) | (this_BOOLPMF_21= RULE_BOOLPMF (this_LPAREN_22= RULE_LPAREN ( (lv_orderedDomain_23_0= RULE_ORDERED_DEF ) ) this_RPAREN_24= RULE_RPAREN )? this_SQUARE_PAREN_L_25= RULE_SQUARE_PAREN_L ( (lv_samples_26_0= ruleboolsample ) )+ this_SQUARE_PAREN_R_27= RULE_SQUARE_PAREN_R ) ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2065:1: ( (this_INTPMF_0= RULE_INTPMF this_SQUARE_PAREN_L_1= RULE_SQUARE_PAREN_L ( (lv_samples_2_0= rulenumeric_int_sample ) )+ this_SQUARE_PAREN_R_3= RULE_SQUARE_PAREN_R (this_SQUARE_PAREN_L_4= RULE_SQUARE_PAREN_L ( (lv_unit_5_0= ruleUnit ) ) this_SQUARE_PAREN_R_6= RULE_SQUARE_PAREN_R )? ) | (this_DOUBLEPMF_7= RULE_DOUBLEPMF this_SQUARE_PAREN_L_8= RULE_SQUARE_PAREN_L ( (lv_samples_9_0= rulenumeric_real_sample ) )+ this_SQUARE_PAREN_R_10= RULE_SQUARE_PAREN_R (this_SQUARE_PAREN_L_11= RULE_SQUARE_PAREN_L ( (lv_unit_12_0= ruleUnit ) ) this_SQUARE_PAREN_R_13= RULE_SQUARE_PAREN_R )? ) | (this_ENUMPMF_14= RULE_ENUMPMF (this_LPAREN_15= RULE_LPAREN ( (lv_orderedDomain_16_0= RULE_ORDERED_DEF ) ) this_RPAREN_17= RULE_RPAREN )? this_SQUARE_PAREN_L_18= RULE_SQUARE_PAREN_L ( (lv_samples_19_0= rulestringsample ) )+ this_SQUARE_PAREN_R_20= RULE_SQUARE_PAREN_R ) | (this_BOOLPMF_21= RULE_BOOLPMF (this_LPAREN_22= RULE_LPAREN ( (lv_orderedDomain_23_0= RULE_ORDERED_DEF ) ) this_RPAREN_24= RULE_RPAREN )? this_SQUARE_PAREN_L_25= RULE_SQUARE_PAREN_L ( (lv_samples_26_0= ruleboolsample ) )+ this_SQUARE_PAREN_R_27= RULE_SQUARE_PAREN_R ) )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2065:1: ( (this_INTPMF_0= RULE_INTPMF this_SQUARE_PAREN_L_1= RULE_SQUARE_PAREN_L ( (lv_samples_2_0= rulenumeric_int_sample ) )+ this_SQUARE_PAREN_R_3= RULE_SQUARE_PAREN_R (this_SQUARE_PAREN_L_4= RULE_SQUARE_PAREN_L ( (lv_unit_5_0= ruleUnit ) ) this_SQUARE_PAREN_R_6= RULE_SQUARE_PAREN_R )? ) | (this_DOUBLEPMF_7= RULE_DOUBLEPMF this_SQUARE_PAREN_L_8= RULE_SQUARE_PAREN_L ( (lv_samples_9_0= rulenumeric_real_sample ) )+ this_SQUARE_PAREN_R_10= RULE_SQUARE_PAREN_R (this_SQUARE_PAREN_L_11= RULE_SQUARE_PAREN_L ( (lv_unit_12_0= ruleUnit ) ) this_SQUARE_PAREN_R_13= RULE_SQUARE_PAREN_R )? ) | (this_ENUMPMF_14= RULE_ENUMPMF (this_LPAREN_15= RULE_LPAREN ( (lv_orderedDomain_16_0= RULE_ORDERED_DEF ) ) this_RPAREN_17= RULE_RPAREN )? this_SQUARE_PAREN_L_18= RULE_SQUARE_PAREN_L ( (lv_samples_19_0= rulestringsample ) )+ this_SQUARE_PAREN_R_20= RULE_SQUARE_PAREN_R ) | (this_BOOLPMF_21= RULE_BOOLPMF (this_LPAREN_22= RULE_LPAREN ( (lv_orderedDomain_23_0= RULE_ORDERED_DEF ) ) this_RPAREN_24= RULE_RPAREN )? this_SQUARE_PAREN_L_25= RULE_SQUARE_PAREN_L ( (lv_samples_26_0= ruleboolsample ) )+ this_SQUARE_PAREN_R_27= RULE_SQUARE_PAREN_R ) )
            int alt32=4;
            switch ( input.LA(1) ) {
            case RULE_INTPMF:
                {
                alt32=1;
                }
                break;
            case RULE_DOUBLEPMF:
                {
                alt32=2;
                }
                break;
            case RULE_ENUMPMF:
                {
                alt32=3;
                }
                break;
            case RULE_BOOLPMF:
                {
                alt32=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2065:2: (this_INTPMF_0= RULE_INTPMF this_SQUARE_PAREN_L_1= RULE_SQUARE_PAREN_L ( (lv_samples_2_0= rulenumeric_int_sample ) )+ this_SQUARE_PAREN_R_3= RULE_SQUARE_PAREN_R (this_SQUARE_PAREN_L_4= RULE_SQUARE_PAREN_L ( (lv_unit_5_0= ruleUnit ) ) this_SQUARE_PAREN_R_6= RULE_SQUARE_PAREN_R )? )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2065:2: (this_INTPMF_0= RULE_INTPMF this_SQUARE_PAREN_L_1= RULE_SQUARE_PAREN_L ( (lv_samples_2_0= rulenumeric_int_sample ) )+ this_SQUARE_PAREN_R_3= RULE_SQUARE_PAREN_R (this_SQUARE_PAREN_L_4= RULE_SQUARE_PAREN_L ( (lv_unit_5_0= ruleUnit ) ) this_SQUARE_PAREN_R_6= RULE_SQUARE_PAREN_R )? )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2065:3: this_INTPMF_0= RULE_INTPMF this_SQUARE_PAREN_L_1= RULE_SQUARE_PAREN_L ( (lv_samples_2_0= rulenumeric_int_sample ) )+ this_SQUARE_PAREN_R_3= RULE_SQUARE_PAREN_R (this_SQUARE_PAREN_L_4= RULE_SQUARE_PAREN_L ( (lv_unit_5_0= ruleUnit ) ) this_SQUARE_PAREN_R_6= RULE_SQUARE_PAREN_R )?
                    {
                    this_INTPMF_0=(Token)match(input,RULE_INTPMF,FollowSets000.FOLLOW_RULE_INTPMF_in_ruleProbabilityMassFunction4583); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_INTPMF_0, grammarAccess.getProbabilityMassFunctionAccess().getINTPMFTerminalRuleCall_0_0()); 
                          
                    }
                    this_SQUARE_PAREN_L_1=(Token)match(input,RULE_SQUARE_PAREN_L,FollowSets000.FOLLOW_RULE_SQUARE_PAREN_L_in_ruleProbabilityMassFunction4593); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SQUARE_PAREN_L_1, grammarAccess.getProbabilityMassFunctionAccess().getSQUARE_PAREN_LTerminalRuleCall_0_1()); 
                          
                    }
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2073:1: ( (lv_samples_2_0= rulenumeric_int_sample ) )+
                    int cnt24=0;
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==RULE_LPAREN) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2074:1: (lv_samples_2_0= rulenumeric_int_sample )
                    	    {
                    	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2074:1: (lv_samples_2_0= rulenumeric_int_sample )
                    	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2075:3: lv_samples_2_0= rulenumeric_int_sample
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getProbabilityMassFunctionAccess().getSamplesNumeric_int_sampleParserRuleCall_0_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_rulenumeric_int_sample_in_ruleProbabilityMassFunction4613);
                    	    lv_samples_2_0=rulenumeric_int_sample();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getProbabilityMassFunctionRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"samples",
                    	              		lv_samples_2_0, 
                    	              		"numeric_int_sample");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt24 >= 1 ) break loop24;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(24, input);
                                throw eee;
                        }
                        cnt24++;
                    } while (true);

                    this_SQUARE_PAREN_R_3=(Token)match(input,RULE_SQUARE_PAREN_R,FollowSets000.FOLLOW_RULE_SQUARE_PAREN_R_in_ruleProbabilityMassFunction4625); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SQUARE_PAREN_R_3, grammarAccess.getProbabilityMassFunctionAccess().getSQUARE_PAREN_RTerminalRuleCall_0_3()); 
                          
                    }
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2095:1: (this_SQUARE_PAREN_L_4= RULE_SQUARE_PAREN_L ( (lv_unit_5_0= ruleUnit ) ) this_SQUARE_PAREN_R_6= RULE_SQUARE_PAREN_R )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==RULE_SQUARE_PAREN_L) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2095:2: this_SQUARE_PAREN_L_4= RULE_SQUARE_PAREN_L ( (lv_unit_5_0= ruleUnit ) ) this_SQUARE_PAREN_R_6= RULE_SQUARE_PAREN_R
                            {
                            this_SQUARE_PAREN_L_4=(Token)match(input,RULE_SQUARE_PAREN_L,FollowSets000.FOLLOW_RULE_SQUARE_PAREN_L_in_ruleProbabilityMassFunction4636); if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                               
                                  newLeafNode(this_SQUARE_PAREN_L_4, grammarAccess.getProbabilityMassFunctionAccess().getSQUARE_PAREN_LTerminalRuleCall_0_4_0()); 
                                  
                            }
                            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2099:1: ( (lv_unit_5_0= ruleUnit ) )
                            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2100:1: (lv_unit_5_0= ruleUnit )
                            {
                            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2100:1: (lv_unit_5_0= ruleUnit )
                            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2101:3: lv_unit_5_0= ruleUnit
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getProbabilityMassFunctionAccess().getUnitUnitParserRuleCall_0_4_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleUnit_in_ruleProbabilityMassFunction4656);
                            lv_unit_5_0=ruleUnit();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getProbabilityMassFunctionRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"unit",
                                      		lv_unit_5_0, 
                                      		"Unit");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            this_SQUARE_PAREN_R_6=(Token)match(input,RULE_SQUARE_PAREN_R,FollowSets000.FOLLOW_RULE_SQUARE_PAREN_R_in_ruleProbabilityMassFunction4667); if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                               
                                  newLeafNode(this_SQUARE_PAREN_R_6, grammarAccess.getProbabilityMassFunctionAccess().getSQUARE_PAREN_RTerminalRuleCall_0_4_2()); 
                                  
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2122:6: (this_DOUBLEPMF_7= RULE_DOUBLEPMF this_SQUARE_PAREN_L_8= RULE_SQUARE_PAREN_L ( (lv_samples_9_0= rulenumeric_real_sample ) )+ this_SQUARE_PAREN_R_10= RULE_SQUARE_PAREN_R (this_SQUARE_PAREN_L_11= RULE_SQUARE_PAREN_L ( (lv_unit_12_0= ruleUnit ) ) this_SQUARE_PAREN_R_13= RULE_SQUARE_PAREN_R )? )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2122:6: (this_DOUBLEPMF_7= RULE_DOUBLEPMF this_SQUARE_PAREN_L_8= RULE_SQUARE_PAREN_L ( (lv_samples_9_0= rulenumeric_real_sample ) )+ this_SQUARE_PAREN_R_10= RULE_SQUARE_PAREN_R (this_SQUARE_PAREN_L_11= RULE_SQUARE_PAREN_L ( (lv_unit_12_0= ruleUnit ) ) this_SQUARE_PAREN_R_13= RULE_SQUARE_PAREN_R )? )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2122:7: this_DOUBLEPMF_7= RULE_DOUBLEPMF this_SQUARE_PAREN_L_8= RULE_SQUARE_PAREN_L ( (lv_samples_9_0= rulenumeric_real_sample ) )+ this_SQUARE_PAREN_R_10= RULE_SQUARE_PAREN_R (this_SQUARE_PAREN_L_11= RULE_SQUARE_PAREN_L ( (lv_unit_12_0= ruleUnit ) ) this_SQUARE_PAREN_R_13= RULE_SQUARE_PAREN_R )?
                    {
                    this_DOUBLEPMF_7=(Token)match(input,RULE_DOUBLEPMF,FollowSets000.FOLLOW_RULE_DOUBLEPMF_in_ruleProbabilityMassFunction4687); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_DOUBLEPMF_7, grammarAccess.getProbabilityMassFunctionAccess().getDOUBLEPMFTerminalRuleCall_1_0()); 
                          
                    }
                    this_SQUARE_PAREN_L_8=(Token)match(input,RULE_SQUARE_PAREN_L,FollowSets000.FOLLOW_RULE_SQUARE_PAREN_L_in_ruleProbabilityMassFunction4697); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SQUARE_PAREN_L_8, grammarAccess.getProbabilityMassFunctionAccess().getSQUARE_PAREN_LTerminalRuleCall_1_1()); 
                          
                    }
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2130:1: ( (lv_samples_9_0= rulenumeric_real_sample ) )+
                    int cnt26=0;
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==RULE_LPAREN) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2131:1: (lv_samples_9_0= rulenumeric_real_sample )
                    	    {
                    	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2131:1: (lv_samples_9_0= rulenumeric_real_sample )
                    	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2132:3: lv_samples_9_0= rulenumeric_real_sample
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getProbabilityMassFunctionAccess().getSamplesNumeric_real_sampleParserRuleCall_1_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_rulenumeric_real_sample_in_ruleProbabilityMassFunction4717);
                    	    lv_samples_9_0=rulenumeric_real_sample();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getProbabilityMassFunctionRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"samples",
                    	              		lv_samples_9_0, 
                    	              		"numeric_real_sample");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt26 >= 1 ) break loop26;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(26, input);
                                throw eee;
                        }
                        cnt26++;
                    } while (true);

                    this_SQUARE_PAREN_R_10=(Token)match(input,RULE_SQUARE_PAREN_R,FollowSets000.FOLLOW_RULE_SQUARE_PAREN_R_in_ruleProbabilityMassFunction4729); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SQUARE_PAREN_R_10, grammarAccess.getProbabilityMassFunctionAccess().getSQUARE_PAREN_RTerminalRuleCall_1_3()); 
                          
                    }
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2152:1: (this_SQUARE_PAREN_L_11= RULE_SQUARE_PAREN_L ( (lv_unit_12_0= ruleUnit ) ) this_SQUARE_PAREN_R_13= RULE_SQUARE_PAREN_R )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==RULE_SQUARE_PAREN_L) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2152:2: this_SQUARE_PAREN_L_11= RULE_SQUARE_PAREN_L ( (lv_unit_12_0= ruleUnit ) ) this_SQUARE_PAREN_R_13= RULE_SQUARE_PAREN_R
                            {
                            this_SQUARE_PAREN_L_11=(Token)match(input,RULE_SQUARE_PAREN_L,FollowSets000.FOLLOW_RULE_SQUARE_PAREN_L_in_ruleProbabilityMassFunction4740); if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                               
                                  newLeafNode(this_SQUARE_PAREN_L_11, grammarAccess.getProbabilityMassFunctionAccess().getSQUARE_PAREN_LTerminalRuleCall_1_4_0()); 
                                  
                            }
                            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2156:1: ( (lv_unit_12_0= ruleUnit ) )
                            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2157:1: (lv_unit_12_0= ruleUnit )
                            {
                            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2157:1: (lv_unit_12_0= ruleUnit )
                            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2158:3: lv_unit_12_0= ruleUnit
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getProbabilityMassFunctionAccess().getUnitUnitParserRuleCall_1_4_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleUnit_in_ruleProbabilityMassFunction4760);
                            lv_unit_12_0=ruleUnit();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getProbabilityMassFunctionRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"unit",
                                      		lv_unit_12_0, 
                                      		"Unit");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            this_SQUARE_PAREN_R_13=(Token)match(input,RULE_SQUARE_PAREN_R,FollowSets000.FOLLOW_RULE_SQUARE_PAREN_R_in_ruleProbabilityMassFunction4771); if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                               
                                  newLeafNode(this_SQUARE_PAREN_R_13, grammarAccess.getProbabilityMassFunctionAccess().getSQUARE_PAREN_RTerminalRuleCall_1_4_2()); 
                                  
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2179:6: (this_ENUMPMF_14= RULE_ENUMPMF (this_LPAREN_15= RULE_LPAREN ( (lv_orderedDomain_16_0= RULE_ORDERED_DEF ) ) this_RPAREN_17= RULE_RPAREN )? this_SQUARE_PAREN_L_18= RULE_SQUARE_PAREN_L ( (lv_samples_19_0= rulestringsample ) )+ this_SQUARE_PAREN_R_20= RULE_SQUARE_PAREN_R )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2179:6: (this_ENUMPMF_14= RULE_ENUMPMF (this_LPAREN_15= RULE_LPAREN ( (lv_orderedDomain_16_0= RULE_ORDERED_DEF ) ) this_RPAREN_17= RULE_RPAREN )? this_SQUARE_PAREN_L_18= RULE_SQUARE_PAREN_L ( (lv_samples_19_0= rulestringsample ) )+ this_SQUARE_PAREN_R_20= RULE_SQUARE_PAREN_R )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2179:7: this_ENUMPMF_14= RULE_ENUMPMF (this_LPAREN_15= RULE_LPAREN ( (lv_orderedDomain_16_0= RULE_ORDERED_DEF ) ) this_RPAREN_17= RULE_RPAREN )? this_SQUARE_PAREN_L_18= RULE_SQUARE_PAREN_L ( (lv_samples_19_0= rulestringsample ) )+ this_SQUARE_PAREN_R_20= RULE_SQUARE_PAREN_R
                    {
                    this_ENUMPMF_14=(Token)match(input,RULE_ENUMPMF,FollowSets000.FOLLOW_RULE_ENUMPMF_in_ruleProbabilityMassFunction4791); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ENUMPMF_14, grammarAccess.getProbabilityMassFunctionAccess().getENUMPMFTerminalRuleCall_2_0()); 
                          
                    }
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2183:1: (this_LPAREN_15= RULE_LPAREN ( (lv_orderedDomain_16_0= RULE_ORDERED_DEF ) ) this_RPAREN_17= RULE_RPAREN )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==RULE_LPAREN) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2183:2: this_LPAREN_15= RULE_LPAREN ( (lv_orderedDomain_16_0= RULE_ORDERED_DEF ) ) this_RPAREN_17= RULE_RPAREN
                            {
                            this_LPAREN_15=(Token)match(input,RULE_LPAREN,FollowSets000.FOLLOW_RULE_LPAREN_in_ruleProbabilityMassFunction4802); if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                               
                                  newLeafNode(this_LPAREN_15, grammarAccess.getProbabilityMassFunctionAccess().getLPARENTerminalRuleCall_2_1_0()); 
                                  
                            }
                            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2187:1: ( (lv_orderedDomain_16_0= RULE_ORDERED_DEF ) )
                            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2188:1: (lv_orderedDomain_16_0= RULE_ORDERED_DEF )
                            {
                            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2188:1: (lv_orderedDomain_16_0= RULE_ORDERED_DEF )
                            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2189:3: lv_orderedDomain_16_0= RULE_ORDERED_DEF
                            {
                            lv_orderedDomain_16_0=(Token)match(input,RULE_ORDERED_DEF,FollowSets000.FOLLOW_RULE_ORDERED_DEF_in_ruleProbabilityMassFunction4818); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_orderedDomain_16_0, grammarAccess.getProbabilityMassFunctionAccess().getOrderedDomainORDERED_DEFTerminalRuleCall_2_1_1_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getProbabilityMassFunctionRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"orderedDomain",
                                      		true, 
                                      		"ORDERED_DEF");
                              	    
                            }

                            }


                            }

                            this_RPAREN_17=(Token)match(input,RULE_RPAREN,FollowSets000.FOLLOW_RULE_RPAREN_in_ruleProbabilityMassFunction4834); if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                               
                                  newLeafNode(this_RPAREN_17, grammarAccess.getProbabilityMassFunctionAccess().getRPARENTerminalRuleCall_2_1_2()); 
                                  
                            }

                            }
                            break;

                    }

                    this_SQUARE_PAREN_L_18=(Token)match(input,RULE_SQUARE_PAREN_L,FollowSets000.FOLLOW_RULE_SQUARE_PAREN_L_in_ruleProbabilityMassFunction4846); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SQUARE_PAREN_L_18, grammarAccess.getProbabilityMassFunctionAccess().getSQUARE_PAREN_LTerminalRuleCall_2_2()); 
                          
                    }
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2213:1: ( (lv_samples_19_0= rulestringsample ) )+
                    int cnt29=0;
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==RULE_LPAREN) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2214:1: (lv_samples_19_0= rulestringsample )
                    	    {
                    	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2214:1: (lv_samples_19_0= rulestringsample )
                    	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2215:3: lv_samples_19_0= rulestringsample
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getProbabilityMassFunctionAccess().getSamplesStringsampleParserRuleCall_2_3_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_rulestringsample_in_ruleProbabilityMassFunction4866);
                    	    lv_samples_19_0=rulestringsample();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getProbabilityMassFunctionRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"samples",
                    	              		lv_samples_19_0, 
                    	              		"stringsample");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt29 >= 1 ) break loop29;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(29, input);
                                throw eee;
                        }
                        cnt29++;
                    } while (true);

                    this_SQUARE_PAREN_R_20=(Token)match(input,RULE_SQUARE_PAREN_R,FollowSets000.FOLLOW_RULE_SQUARE_PAREN_R_in_ruleProbabilityMassFunction4878); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SQUARE_PAREN_R_20, grammarAccess.getProbabilityMassFunctionAccess().getSQUARE_PAREN_RTerminalRuleCall_2_4()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2236:6: (this_BOOLPMF_21= RULE_BOOLPMF (this_LPAREN_22= RULE_LPAREN ( (lv_orderedDomain_23_0= RULE_ORDERED_DEF ) ) this_RPAREN_24= RULE_RPAREN )? this_SQUARE_PAREN_L_25= RULE_SQUARE_PAREN_L ( (lv_samples_26_0= ruleboolsample ) )+ this_SQUARE_PAREN_R_27= RULE_SQUARE_PAREN_R )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2236:6: (this_BOOLPMF_21= RULE_BOOLPMF (this_LPAREN_22= RULE_LPAREN ( (lv_orderedDomain_23_0= RULE_ORDERED_DEF ) ) this_RPAREN_24= RULE_RPAREN )? this_SQUARE_PAREN_L_25= RULE_SQUARE_PAREN_L ( (lv_samples_26_0= ruleboolsample ) )+ this_SQUARE_PAREN_R_27= RULE_SQUARE_PAREN_R )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2236:7: this_BOOLPMF_21= RULE_BOOLPMF (this_LPAREN_22= RULE_LPAREN ( (lv_orderedDomain_23_0= RULE_ORDERED_DEF ) ) this_RPAREN_24= RULE_RPAREN )? this_SQUARE_PAREN_L_25= RULE_SQUARE_PAREN_L ( (lv_samples_26_0= ruleboolsample ) )+ this_SQUARE_PAREN_R_27= RULE_SQUARE_PAREN_R
                    {
                    this_BOOLPMF_21=(Token)match(input,RULE_BOOLPMF,FollowSets000.FOLLOW_RULE_BOOLPMF_in_ruleProbabilityMassFunction4896); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_BOOLPMF_21, grammarAccess.getProbabilityMassFunctionAccess().getBOOLPMFTerminalRuleCall_3_0()); 
                          
                    }
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2240:1: (this_LPAREN_22= RULE_LPAREN ( (lv_orderedDomain_23_0= RULE_ORDERED_DEF ) ) this_RPAREN_24= RULE_RPAREN )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==RULE_LPAREN) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2240:2: this_LPAREN_22= RULE_LPAREN ( (lv_orderedDomain_23_0= RULE_ORDERED_DEF ) ) this_RPAREN_24= RULE_RPAREN
                            {
                            this_LPAREN_22=(Token)match(input,RULE_LPAREN,FollowSets000.FOLLOW_RULE_LPAREN_in_ruleProbabilityMassFunction4907); if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                               
                                  newLeafNode(this_LPAREN_22, grammarAccess.getProbabilityMassFunctionAccess().getLPARENTerminalRuleCall_3_1_0()); 
                                  
                            }
                            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2244:1: ( (lv_orderedDomain_23_0= RULE_ORDERED_DEF ) )
                            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2245:1: (lv_orderedDomain_23_0= RULE_ORDERED_DEF )
                            {
                            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2245:1: (lv_orderedDomain_23_0= RULE_ORDERED_DEF )
                            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2246:3: lv_orderedDomain_23_0= RULE_ORDERED_DEF
                            {
                            lv_orderedDomain_23_0=(Token)match(input,RULE_ORDERED_DEF,FollowSets000.FOLLOW_RULE_ORDERED_DEF_in_ruleProbabilityMassFunction4923); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_orderedDomain_23_0, grammarAccess.getProbabilityMassFunctionAccess().getOrderedDomainORDERED_DEFTerminalRuleCall_3_1_1_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getProbabilityMassFunctionRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"orderedDomain",
                                      		true, 
                                      		"ORDERED_DEF");
                              	    
                            }

                            }


                            }

                            this_RPAREN_24=(Token)match(input,RULE_RPAREN,FollowSets000.FOLLOW_RULE_RPAREN_in_ruleProbabilityMassFunction4939); if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                               
                                  newLeafNode(this_RPAREN_24, grammarAccess.getProbabilityMassFunctionAccess().getRPARENTerminalRuleCall_3_1_2()); 
                                  
                            }

                            }
                            break;

                    }

                    this_SQUARE_PAREN_L_25=(Token)match(input,RULE_SQUARE_PAREN_L,FollowSets000.FOLLOW_RULE_SQUARE_PAREN_L_in_ruleProbabilityMassFunction4951); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SQUARE_PAREN_L_25, grammarAccess.getProbabilityMassFunctionAccess().getSQUARE_PAREN_LTerminalRuleCall_3_2()); 
                          
                    }
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2270:1: ( (lv_samples_26_0= ruleboolsample ) )+
                    int cnt31=0;
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==RULE_LPAREN) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2271:1: (lv_samples_26_0= ruleboolsample )
                    	    {
                    	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2271:1: (lv_samples_26_0= ruleboolsample )
                    	    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2272:3: lv_samples_26_0= ruleboolsample
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getProbabilityMassFunctionAccess().getSamplesBoolsampleParserRuleCall_3_3_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleboolsample_in_ruleProbabilityMassFunction4971);
                    	    lv_samples_26_0=ruleboolsample();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getProbabilityMassFunctionRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"samples",
                    	              		lv_samples_26_0, 
                    	              		"boolsample");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt31 >= 1 ) break loop31;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(31, input);
                                throw eee;
                        }
                        cnt31++;
                    } while (true);

                    this_SQUARE_PAREN_R_27=(Token)match(input,RULE_SQUARE_PAREN_R,FollowSets000.FOLLOW_RULE_SQUARE_PAREN_R_in_ruleProbabilityMassFunction4983); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SQUARE_PAREN_R_27, grammarAccess.getProbabilityMassFunctionAccess().getSQUARE_PAREN_RTerminalRuleCall_3_4()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProbabilityMassFunction"


    // $ANTLR start "entryRulenumeric_int_sample"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2300:1: entryRulenumeric_int_sample returns [EObject current=null] : iv_rulenumeric_int_sample= rulenumeric_int_sample EOF ;
    public final EObject entryRulenumeric_int_sample() throws RecognitionException {
        EObject current = null;

        EObject iv_rulenumeric_int_sample = null;


        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2301:2: (iv_rulenumeric_int_sample= rulenumeric_int_sample EOF )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2302:2: iv_rulenumeric_int_sample= rulenumeric_int_sample EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumeric_int_sampleRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulenumeric_int_sample_in_entryRulenumeric_int_sample5019);
            iv_rulenumeric_int_sample=rulenumeric_int_sample();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulenumeric_int_sample; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulenumeric_int_sample5029); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulenumeric_int_sample"


    // $ANTLR start "rulenumeric_int_sample"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2309:1: rulenumeric_int_sample returns [EObject current=null] : (this_LPAREN_0= RULE_LPAREN ( (lv_value_1_0= ruleSIGNED_INT ) ) this_SEMI_2= RULE_SEMI ( (lv_probability_3_0= RULE_DOUBLE ) ) this_RPAREN_4= RULE_RPAREN ) ;
    public final EObject rulenumeric_int_sample() throws RecognitionException {
        EObject current = null;

        Token this_LPAREN_0=null;
        Token this_SEMI_2=null;
        Token lv_probability_3_0=null;
        Token this_RPAREN_4=null;
        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2312:28: ( (this_LPAREN_0= RULE_LPAREN ( (lv_value_1_0= ruleSIGNED_INT ) ) this_SEMI_2= RULE_SEMI ( (lv_probability_3_0= RULE_DOUBLE ) ) this_RPAREN_4= RULE_RPAREN ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2313:1: (this_LPAREN_0= RULE_LPAREN ( (lv_value_1_0= ruleSIGNED_INT ) ) this_SEMI_2= RULE_SEMI ( (lv_probability_3_0= RULE_DOUBLE ) ) this_RPAREN_4= RULE_RPAREN )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2313:1: (this_LPAREN_0= RULE_LPAREN ( (lv_value_1_0= ruleSIGNED_INT ) ) this_SEMI_2= RULE_SEMI ( (lv_probability_3_0= RULE_DOUBLE ) ) this_RPAREN_4= RULE_RPAREN )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2313:2: this_LPAREN_0= RULE_LPAREN ( (lv_value_1_0= ruleSIGNED_INT ) ) this_SEMI_2= RULE_SEMI ( (lv_probability_3_0= RULE_DOUBLE ) ) this_RPAREN_4= RULE_RPAREN
            {
            this_LPAREN_0=(Token)match(input,RULE_LPAREN,FollowSets000.FOLLOW_RULE_LPAREN_in_rulenumeric_int_sample5065); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_LPAREN_0, grammarAccess.getNumeric_int_sampleAccess().getLPARENTerminalRuleCall_0()); 
                  
            }
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2317:1: ( (lv_value_1_0= ruleSIGNED_INT ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2318:1: (lv_value_1_0= ruleSIGNED_INT )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2318:1: (lv_value_1_0= ruleSIGNED_INT )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2319:3: lv_value_1_0= ruleSIGNED_INT
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNumeric_int_sampleAccess().getValueSIGNED_INTParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleSIGNED_INT_in_rulenumeric_int_sample5085);
            lv_value_1_0=ruleSIGNED_INT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNumeric_int_sampleRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"SIGNED_INT");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            this_SEMI_2=(Token)match(input,RULE_SEMI,FollowSets000.FOLLOW_RULE_SEMI_in_rulenumeric_int_sample5096); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_2, grammarAccess.getNumeric_int_sampleAccess().getSEMITerminalRuleCall_2()); 
                  
            }
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2339:1: ( (lv_probability_3_0= RULE_DOUBLE ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2340:1: (lv_probability_3_0= RULE_DOUBLE )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2340:1: (lv_probability_3_0= RULE_DOUBLE )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2341:3: lv_probability_3_0= RULE_DOUBLE
            {
            lv_probability_3_0=(Token)match(input,RULE_DOUBLE,FollowSets000.FOLLOW_RULE_DOUBLE_in_rulenumeric_int_sample5112); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_probability_3_0, grammarAccess.getNumeric_int_sampleAccess().getProbabilityDOUBLETerminalRuleCall_3_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getNumeric_int_sampleRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"probability",
                      		lv_probability_3_0, 
                      		"DOUBLE");
              	    
            }

            }


            }

            this_RPAREN_4=(Token)match(input,RULE_RPAREN,FollowSets000.FOLLOW_RULE_RPAREN_in_rulenumeric_int_sample5128); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_RPAREN_4, grammarAccess.getNumeric_int_sampleAccess().getRPARENTerminalRuleCall_4()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulenumeric_int_sample"


    // $ANTLR start "entryRulenumeric_real_sample"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2369:1: entryRulenumeric_real_sample returns [EObject current=null] : iv_rulenumeric_real_sample= rulenumeric_real_sample EOF ;
    public final EObject entryRulenumeric_real_sample() throws RecognitionException {
        EObject current = null;

        EObject iv_rulenumeric_real_sample = null;


        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2370:2: (iv_rulenumeric_real_sample= rulenumeric_real_sample EOF )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2371:2: iv_rulenumeric_real_sample= rulenumeric_real_sample EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumeric_real_sampleRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulenumeric_real_sample_in_entryRulenumeric_real_sample5163);
            iv_rulenumeric_real_sample=rulenumeric_real_sample();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulenumeric_real_sample; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulenumeric_real_sample5173); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulenumeric_real_sample"


    // $ANTLR start "rulenumeric_real_sample"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2378:1: rulenumeric_real_sample returns [EObject current=null] : (this_LPAREN_0= RULE_LPAREN ( (lv_value_1_0= ruleSIGNED_NUMBER ) ) this_SEMI_2= RULE_SEMI ( (lv_probability_3_0= RULE_DOUBLE ) ) this_RPAREN_4= RULE_RPAREN ) ;
    public final EObject rulenumeric_real_sample() throws RecognitionException {
        EObject current = null;

        Token this_LPAREN_0=null;
        Token this_SEMI_2=null;
        Token lv_probability_3_0=null;
        Token this_RPAREN_4=null;
        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2381:28: ( (this_LPAREN_0= RULE_LPAREN ( (lv_value_1_0= ruleSIGNED_NUMBER ) ) this_SEMI_2= RULE_SEMI ( (lv_probability_3_0= RULE_DOUBLE ) ) this_RPAREN_4= RULE_RPAREN ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2382:1: (this_LPAREN_0= RULE_LPAREN ( (lv_value_1_0= ruleSIGNED_NUMBER ) ) this_SEMI_2= RULE_SEMI ( (lv_probability_3_0= RULE_DOUBLE ) ) this_RPAREN_4= RULE_RPAREN )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2382:1: (this_LPAREN_0= RULE_LPAREN ( (lv_value_1_0= ruleSIGNED_NUMBER ) ) this_SEMI_2= RULE_SEMI ( (lv_probability_3_0= RULE_DOUBLE ) ) this_RPAREN_4= RULE_RPAREN )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2382:2: this_LPAREN_0= RULE_LPAREN ( (lv_value_1_0= ruleSIGNED_NUMBER ) ) this_SEMI_2= RULE_SEMI ( (lv_probability_3_0= RULE_DOUBLE ) ) this_RPAREN_4= RULE_RPAREN
            {
            this_LPAREN_0=(Token)match(input,RULE_LPAREN,FollowSets000.FOLLOW_RULE_LPAREN_in_rulenumeric_real_sample5209); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_LPAREN_0, grammarAccess.getNumeric_real_sampleAccess().getLPARENTerminalRuleCall_0()); 
                  
            }
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2386:1: ( (lv_value_1_0= ruleSIGNED_NUMBER ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2387:1: (lv_value_1_0= ruleSIGNED_NUMBER )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2387:1: (lv_value_1_0= ruleSIGNED_NUMBER )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2388:3: lv_value_1_0= ruleSIGNED_NUMBER
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNumeric_real_sampleAccess().getValueSIGNED_NUMBERParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleSIGNED_NUMBER_in_rulenumeric_real_sample5229);
            lv_value_1_0=ruleSIGNED_NUMBER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNumeric_real_sampleRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"SIGNED_NUMBER");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            this_SEMI_2=(Token)match(input,RULE_SEMI,FollowSets000.FOLLOW_RULE_SEMI_in_rulenumeric_real_sample5240); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_2, grammarAccess.getNumeric_real_sampleAccess().getSEMITerminalRuleCall_2()); 
                  
            }
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2408:1: ( (lv_probability_3_0= RULE_DOUBLE ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2409:1: (lv_probability_3_0= RULE_DOUBLE )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2409:1: (lv_probability_3_0= RULE_DOUBLE )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2410:3: lv_probability_3_0= RULE_DOUBLE
            {
            lv_probability_3_0=(Token)match(input,RULE_DOUBLE,FollowSets000.FOLLOW_RULE_DOUBLE_in_rulenumeric_real_sample5256); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_probability_3_0, grammarAccess.getNumeric_real_sampleAccess().getProbabilityDOUBLETerminalRuleCall_3_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getNumeric_real_sampleRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"probability",
                      		lv_probability_3_0, 
                      		"DOUBLE");
              	    
            }

            }


            }

            this_RPAREN_4=(Token)match(input,RULE_RPAREN,FollowSets000.FOLLOW_RULE_RPAREN_in_rulenumeric_real_sample5272); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_RPAREN_4, grammarAccess.getNumeric_real_sampleAccess().getRPARENTerminalRuleCall_4()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulenumeric_real_sample"


    // $ANTLR start "entryRulereal_pdf_sample"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2438:1: entryRulereal_pdf_sample returns [EObject current=null] : iv_rulereal_pdf_sample= rulereal_pdf_sample EOF ;
    public final EObject entryRulereal_pdf_sample() throws RecognitionException {
        EObject current = null;

        EObject iv_rulereal_pdf_sample = null;


        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2439:2: (iv_rulereal_pdf_sample= rulereal_pdf_sample EOF )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2440:2: iv_rulereal_pdf_sample= rulereal_pdf_sample EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReal_pdf_sampleRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulereal_pdf_sample_in_entryRulereal_pdf_sample5307);
            iv_rulereal_pdf_sample=rulereal_pdf_sample();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulereal_pdf_sample; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulereal_pdf_sample5317); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulereal_pdf_sample"


    // $ANTLR start "rulereal_pdf_sample"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2447:1: rulereal_pdf_sample returns [EObject current=null] : (this_LPAREN_0= RULE_LPAREN ( (lv_value_1_0= ruleSIGNED_NUMBER ) ) this_SEMI_2= RULE_SEMI ( (lv_probability_3_0= RULE_DOUBLE ) ) this_RPAREN_4= RULE_RPAREN ) ;
    public final EObject rulereal_pdf_sample() throws RecognitionException {
        EObject current = null;

        Token this_LPAREN_0=null;
        Token this_SEMI_2=null;
        Token lv_probability_3_0=null;
        Token this_RPAREN_4=null;
        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2450:28: ( (this_LPAREN_0= RULE_LPAREN ( (lv_value_1_0= ruleSIGNED_NUMBER ) ) this_SEMI_2= RULE_SEMI ( (lv_probability_3_0= RULE_DOUBLE ) ) this_RPAREN_4= RULE_RPAREN ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2451:1: (this_LPAREN_0= RULE_LPAREN ( (lv_value_1_0= ruleSIGNED_NUMBER ) ) this_SEMI_2= RULE_SEMI ( (lv_probability_3_0= RULE_DOUBLE ) ) this_RPAREN_4= RULE_RPAREN )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2451:1: (this_LPAREN_0= RULE_LPAREN ( (lv_value_1_0= ruleSIGNED_NUMBER ) ) this_SEMI_2= RULE_SEMI ( (lv_probability_3_0= RULE_DOUBLE ) ) this_RPAREN_4= RULE_RPAREN )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2451:2: this_LPAREN_0= RULE_LPAREN ( (lv_value_1_0= ruleSIGNED_NUMBER ) ) this_SEMI_2= RULE_SEMI ( (lv_probability_3_0= RULE_DOUBLE ) ) this_RPAREN_4= RULE_RPAREN
            {
            this_LPAREN_0=(Token)match(input,RULE_LPAREN,FollowSets000.FOLLOW_RULE_LPAREN_in_rulereal_pdf_sample5353); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_LPAREN_0, grammarAccess.getReal_pdf_sampleAccess().getLPARENTerminalRuleCall_0()); 
                  
            }
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2455:1: ( (lv_value_1_0= ruleSIGNED_NUMBER ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2456:1: (lv_value_1_0= ruleSIGNED_NUMBER )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2456:1: (lv_value_1_0= ruleSIGNED_NUMBER )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2457:3: lv_value_1_0= ruleSIGNED_NUMBER
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getReal_pdf_sampleAccess().getValueSIGNED_NUMBERParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleSIGNED_NUMBER_in_rulereal_pdf_sample5373);
            lv_value_1_0=ruleSIGNED_NUMBER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getReal_pdf_sampleRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"SIGNED_NUMBER");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            this_SEMI_2=(Token)match(input,RULE_SEMI,FollowSets000.FOLLOW_RULE_SEMI_in_rulereal_pdf_sample5384); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_2, grammarAccess.getReal_pdf_sampleAccess().getSEMITerminalRuleCall_2()); 
                  
            }
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2477:1: ( (lv_probability_3_0= RULE_DOUBLE ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2478:1: (lv_probability_3_0= RULE_DOUBLE )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2478:1: (lv_probability_3_0= RULE_DOUBLE )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2479:3: lv_probability_3_0= RULE_DOUBLE
            {
            lv_probability_3_0=(Token)match(input,RULE_DOUBLE,FollowSets000.FOLLOW_RULE_DOUBLE_in_rulereal_pdf_sample5400); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_probability_3_0, grammarAccess.getReal_pdf_sampleAccess().getProbabilityDOUBLETerminalRuleCall_3_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getReal_pdf_sampleRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"probability",
                      		lv_probability_3_0, 
                      		"DOUBLE");
              	    
            }

            }


            }

            this_RPAREN_4=(Token)match(input,RULE_RPAREN,FollowSets000.FOLLOW_RULE_RPAREN_in_rulereal_pdf_sample5416); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_RPAREN_4, grammarAccess.getReal_pdf_sampleAccess().getRPARENTerminalRuleCall_4()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulereal_pdf_sample"


    // $ANTLR start "entryRulestringsample"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2507:1: entryRulestringsample returns [EObject current=null] : iv_rulestringsample= rulestringsample EOF ;
    public final EObject entryRulestringsample() throws RecognitionException {
        EObject current = null;

        EObject iv_rulestringsample = null;


        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2508:2: (iv_rulestringsample= rulestringsample EOF )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2509:2: iv_rulestringsample= rulestringsample EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringsampleRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulestringsample_in_entryRulestringsample5451);
            iv_rulestringsample=rulestringsample();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulestringsample; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulestringsample5461); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulestringsample"


    // $ANTLR start "rulestringsample"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2516:1: rulestringsample returns [EObject current=null] : (this_LPAREN_0= RULE_LPAREN ( (lv_value_1_0= RULE_STRING ) ) this_SEMI_2= RULE_SEMI ( (lv_probability_3_0= RULE_DOUBLE ) ) this_RPAREN_4= RULE_RPAREN ) ;
    public final EObject rulestringsample() throws RecognitionException {
        EObject current = null;

        Token this_LPAREN_0=null;
        Token lv_value_1_0=null;
        Token this_SEMI_2=null;
        Token lv_probability_3_0=null;
        Token this_RPAREN_4=null;

         enterRule(); 
            
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2519:28: ( (this_LPAREN_0= RULE_LPAREN ( (lv_value_1_0= RULE_STRING ) ) this_SEMI_2= RULE_SEMI ( (lv_probability_3_0= RULE_DOUBLE ) ) this_RPAREN_4= RULE_RPAREN ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2520:1: (this_LPAREN_0= RULE_LPAREN ( (lv_value_1_0= RULE_STRING ) ) this_SEMI_2= RULE_SEMI ( (lv_probability_3_0= RULE_DOUBLE ) ) this_RPAREN_4= RULE_RPAREN )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2520:1: (this_LPAREN_0= RULE_LPAREN ( (lv_value_1_0= RULE_STRING ) ) this_SEMI_2= RULE_SEMI ( (lv_probability_3_0= RULE_DOUBLE ) ) this_RPAREN_4= RULE_RPAREN )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2520:2: this_LPAREN_0= RULE_LPAREN ( (lv_value_1_0= RULE_STRING ) ) this_SEMI_2= RULE_SEMI ( (lv_probability_3_0= RULE_DOUBLE ) ) this_RPAREN_4= RULE_RPAREN
            {
            this_LPAREN_0=(Token)match(input,RULE_LPAREN,FollowSets000.FOLLOW_RULE_LPAREN_in_rulestringsample5497); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_LPAREN_0, grammarAccess.getStringsampleAccess().getLPARENTerminalRuleCall_0()); 
                  
            }
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2524:1: ( (lv_value_1_0= RULE_STRING ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2525:1: (lv_value_1_0= RULE_STRING )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2525:1: (lv_value_1_0= RULE_STRING )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2526:3: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rulestringsample5513); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_1_0, grammarAccess.getStringsampleAccess().getValueSTRINGTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getStringsampleRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"STRING");
              	    
            }

            }


            }

            this_SEMI_2=(Token)match(input,RULE_SEMI,FollowSets000.FOLLOW_RULE_SEMI_in_rulestringsample5529); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_2, grammarAccess.getStringsampleAccess().getSEMITerminalRuleCall_2()); 
                  
            }
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2546:1: ( (lv_probability_3_0= RULE_DOUBLE ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2547:1: (lv_probability_3_0= RULE_DOUBLE )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2547:1: (lv_probability_3_0= RULE_DOUBLE )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2548:3: lv_probability_3_0= RULE_DOUBLE
            {
            lv_probability_3_0=(Token)match(input,RULE_DOUBLE,FollowSets000.FOLLOW_RULE_DOUBLE_in_rulestringsample5545); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_probability_3_0, grammarAccess.getStringsampleAccess().getProbabilityDOUBLETerminalRuleCall_3_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getStringsampleRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"probability",
                      		lv_probability_3_0, 
                      		"DOUBLE");
              	    
            }

            }


            }

            this_RPAREN_4=(Token)match(input,RULE_RPAREN,FollowSets000.FOLLOW_RULE_RPAREN_in_rulestringsample5561); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_RPAREN_4, grammarAccess.getStringsampleAccess().getRPARENTerminalRuleCall_4()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulestringsample"


    // $ANTLR start "entryRuleboolsample"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2576:1: entryRuleboolsample returns [EObject current=null] : iv_ruleboolsample= ruleboolsample EOF ;
    public final EObject entryRuleboolsample() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleboolsample = null;


        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2577:2: (iv_ruleboolsample= ruleboolsample EOF )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2578:2: iv_ruleboolsample= ruleboolsample EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBoolsampleRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleboolsample_in_entryRuleboolsample5596);
            iv_ruleboolsample=ruleboolsample();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleboolsample; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleboolsample5606); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleboolsample"


    // $ANTLR start "ruleboolsample"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2585:1: ruleboolsample returns [EObject current=null] : (this_LPAREN_0= RULE_LPAREN ( (lv_value_1_0= RULE_BOOLEAN_KEYWORDS ) ) this_SEMI_2= RULE_SEMI ( (lv_probability_3_0= RULE_DOUBLE ) ) this_RPAREN_4= RULE_RPAREN ) ;
    public final EObject ruleboolsample() throws RecognitionException {
        EObject current = null;

        Token this_LPAREN_0=null;
        Token lv_value_1_0=null;
        Token this_SEMI_2=null;
        Token lv_probability_3_0=null;
        Token this_RPAREN_4=null;

         enterRule(); 
            
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2588:28: ( (this_LPAREN_0= RULE_LPAREN ( (lv_value_1_0= RULE_BOOLEAN_KEYWORDS ) ) this_SEMI_2= RULE_SEMI ( (lv_probability_3_0= RULE_DOUBLE ) ) this_RPAREN_4= RULE_RPAREN ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2589:1: (this_LPAREN_0= RULE_LPAREN ( (lv_value_1_0= RULE_BOOLEAN_KEYWORDS ) ) this_SEMI_2= RULE_SEMI ( (lv_probability_3_0= RULE_DOUBLE ) ) this_RPAREN_4= RULE_RPAREN )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2589:1: (this_LPAREN_0= RULE_LPAREN ( (lv_value_1_0= RULE_BOOLEAN_KEYWORDS ) ) this_SEMI_2= RULE_SEMI ( (lv_probability_3_0= RULE_DOUBLE ) ) this_RPAREN_4= RULE_RPAREN )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2589:2: this_LPAREN_0= RULE_LPAREN ( (lv_value_1_0= RULE_BOOLEAN_KEYWORDS ) ) this_SEMI_2= RULE_SEMI ( (lv_probability_3_0= RULE_DOUBLE ) ) this_RPAREN_4= RULE_RPAREN
            {
            this_LPAREN_0=(Token)match(input,RULE_LPAREN,FollowSets000.FOLLOW_RULE_LPAREN_in_ruleboolsample5642); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_LPAREN_0, grammarAccess.getBoolsampleAccess().getLPARENTerminalRuleCall_0()); 
                  
            }
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2593:1: ( (lv_value_1_0= RULE_BOOLEAN_KEYWORDS ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2594:1: (lv_value_1_0= RULE_BOOLEAN_KEYWORDS )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2594:1: (lv_value_1_0= RULE_BOOLEAN_KEYWORDS )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2595:3: lv_value_1_0= RULE_BOOLEAN_KEYWORDS
            {
            lv_value_1_0=(Token)match(input,RULE_BOOLEAN_KEYWORDS,FollowSets000.FOLLOW_RULE_BOOLEAN_KEYWORDS_in_ruleboolsample5658); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_1_0, grammarAccess.getBoolsampleAccess().getValueBOOLEAN_KEYWORDSTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getBoolsampleRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"BOOLEAN_KEYWORDS");
              	    
            }

            }


            }

            this_SEMI_2=(Token)match(input,RULE_SEMI,FollowSets000.FOLLOW_RULE_SEMI_in_ruleboolsample5674); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_2, grammarAccess.getBoolsampleAccess().getSEMITerminalRuleCall_2()); 
                  
            }
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2615:1: ( (lv_probability_3_0= RULE_DOUBLE ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2616:1: (lv_probability_3_0= RULE_DOUBLE )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2616:1: (lv_probability_3_0= RULE_DOUBLE )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2617:3: lv_probability_3_0= RULE_DOUBLE
            {
            lv_probability_3_0=(Token)match(input,RULE_DOUBLE,FollowSets000.FOLLOW_RULE_DOUBLE_in_ruleboolsample5690); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_probability_3_0, grammarAccess.getBoolsampleAccess().getProbabilityDOUBLETerminalRuleCall_3_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getBoolsampleRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"probability",
                      		lv_probability_3_0, 
                      		"DOUBLE");
              	    
            }

            }


            }

            this_RPAREN_4=(Token)match(input,RULE_RPAREN,FollowSets000.FOLLOW_RULE_RPAREN_in_ruleboolsample5706); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_RPAREN_4, grammarAccess.getBoolsampleAccess().getRPARENTerminalRuleCall_4()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleboolsample"


    // $ANTLR start "entryRuleSIGNED_NUMBER"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2645:1: entryRuleSIGNED_NUMBER returns [String current=null] : iv_ruleSIGNED_NUMBER= ruleSIGNED_NUMBER EOF ;
    public final String entryRuleSIGNED_NUMBER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSIGNED_NUMBER = null;


        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2646:2: (iv_ruleSIGNED_NUMBER= ruleSIGNED_NUMBER EOF )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2647:2: iv_ruleSIGNED_NUMBER= ruleSIGNED_NUMBER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSIGNED_NUMBERRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSIGNED_NUMBER_in_entryRuleSIGNED_NUMBER5742);
            iv_ruleSIGNED_NUMBER=ruleSIGNED_NUMBER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSIGNED_NUMBER.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSIGNED_NUMBER5753); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSIGNED_NUMBER"


    // $ANTLR start "ruleSIGNED_NUMBER"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2654:1: ruleSIGNED_NUMBER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_DOUBLE_1= RULE_DOUBLE ) ;
    public final AntlrDatatypeRuleToken ruleSIGNED_NUMBER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_DOUBLE_1=null;

         enterRule(); 
            
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2657:28: ( ( (kw= '-' )? this_DOUBLE_1= RULE_DOUBLE ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2658:1: ( (kw= '-' )? this_DOUBLE_1= RULE_DOUBLE )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2658:1: ( (kw= '-' )? this_DOUBLE_1= RULE_DOUBLE )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2658:2: (kw= '-' )? this_DOUBLE_1= RULE_DOUBLE
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2658:2: (kw= '-' )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==31) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2659:2: kw= '-'
                    {
                    kw=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleSIGNED_NUMBER5792); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSIGNED_NUMBERAccess().getHyphenMinusKeyword_0()); 
                          
                    }

                    }
                    break;

            }

            this_DOUBLE_1=(Token)match(input,RULE_DOUBLE,FollowSets000.FOLLOW_RULE_DOUBLE_in_ruleSIGNED_NUMBER5809); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_DOUBLE_1);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_DOUBLE_1, grammarAccess.getSIGNED_NUMBERAccess().getDOUBLETerminalRuleCall_1()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSIGNED_NUMBER"


    // $ANTLR start "entryRuleSIGNED_INT"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2679:1: entryRuleSIGNED_INT returns [String current=null] : iv_ruleSIGNED_INT= ruleSIGNED_INT EOF ;
    public final String entryRuleSIGNED_INT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSIGNED_INT = null;


        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2680:2: (iv_ruleSIGNED_INT= ruleSIGNED_INT EOF )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2681:2: iv_ruleSIGNED_INT= ruleSIGNED_INT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSIGNED_INTRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSIGNED_INT_in_entryRuleSIGNED_INT5855);
            iv_ruleSIGNED_INT=ruleSIGNED_INT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSIGNED_INT.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSIGNED_INT5866); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSIGNED_INT"


    // $ANTLR start "ruleSIGNED_INT"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2688:1: ruleSIGNED_INT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_DECINT_1= RULE_DECINT ) ;
    public final AntlrDatatypeRuleToken ruleSIGNED_INT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_DECINT_1=null;

         enterRule(); 
            
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2691:28: ( ( (kw= '-' )? this_DECINT_1= RULE_DECINT ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2692:1: ( (kw= '-' )? this_DECINT_1= RULE_DECINT )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2692:1: ( (kw= '-' )? this_DECINT_1= RULE_DECINT )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2692:2: (kw= '-' )? this_DECINT_1= RULE_DECINT
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2692:2: (kw= '-' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==31) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2693:2: kw= '-'
                    {
                    kw=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleSIGNED_INT5905); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSIGNED_INTAccess().getHyphenMinusKeyword_0()); 
                          
                    }

                    }
                    break;

            }

            this_DECINT_1=(Token)match(input,RULE_DECINT,FollowSets000.FOLLOW_RULE_DECINT_in_ruleSIGNED_INT5922); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_DECINT_1);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_DECINT_1, grammarAccess.getSIGNED_INTAccess().getDECINTTerminalRuleCall_1()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSIGNED_INT"


    // $ANTLR start "ruleVariableCharacterisationType"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2713:1: ruleVariableCharacterisationType returns [Enumerator current=null] : ( (enumLiteral_0= 'TYPE' ) | (enumLiteral_1= 'BYTESIZE' ) | (enumLiteral_2= 'NUMBER_OF_ELEMENTS' ) | (enumLiteral_3= 'VALUE' ) | (enumLiteral_4= 'STRUCTURE' ) ) ;
    public final Enumerator ruleVariableCharacterisationType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;

         enterRule(); 
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2715:28: ( ( (enumLiteral_0= 'TYPE' ) | (enumLiteral_1= 'BYTESIZE' ) | (enumLiteral_2= 'NUMBER_OF_ELEMENTS' ) | (enumLiteral_3= 'VALUE' ) | (enumLiteral_4= 'STRUCTURE' ) ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2716:1: ( (enumLiteral_0= 'TYPE' ) | (enumLiteral_1= 'BYTESIZE' ) | (enumLiteral_2= 'NUMBER_OF_ELEMENTS' ) | (enumLiteral_3= 'VALUE' ) | (enumLiteral_4= 'STRUCTURE' ) )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2716:1: ( (enumLiteral_0= 'TYPE' ) | (enumLiteral_1= 'BYTESIZE' ) | (enumLiteral_2= 'NUMBER_OF_ELEMENTS' ) | (enumLiteral_3= 'VALUE' ) | (enumLiteral_4= 'STRUCTURE' ) )
            int alt35=5;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt35=1;
                }
                break;
            case 35:
                {
                alt35=2;
                }
                break;
            case 36:
                {
                alt35=3;
                }
                break;
            case 37:
                {
                alt35=4;
                }
                break;
            case 38:
                {
                alt35=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2716:2: (enumLiteral_0= 'TYPE' )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2716:2: (enumLiteral_0= 'TYPE' )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2716:4: enumLiteral_0= 'TYPE'
                    {
                    enumLiteral_0=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleVariableCharacterisationType5981); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVariableCharacterisationTypeAccess().getTYPEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getVariableCharacterisationTypeAccess().getTYPEEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2722:6: (enumLiteral_1= 'BYTESIZE' )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2722:6: (enumLiteral_1= 'BYTESIZE' )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2722:8: enumLiteral_1= 'BYTESIZE'
                    {
                    enumLiteral_1=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleVariableCharacterisationType5998); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVariableCharacterisationTypeAccess().getBYTESIZEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getVariableCharacterisationTypeAccess().getBYTESIZEEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2728:6: (enumLiteral_2= 'NUMBER_OF_ELEMENTS' )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2728:6: (enumLiteral_2= 'NUMBER_OF_ELEMENTS' )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2728:8: enumLiteral_2= 'NUMBER_OF_ELEMENTS'
                    {
                    enumLiteral_2=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleVariableCharacterisationType6015); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVariableCharacterisationTypeAccess().getNUMBER_OF_ELEMENTSEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getVariableCharacterisationTypeAccess().getNUMBER_OF_ELEMENTSEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2734:6: (enumLiteral_3= 'VALUE' )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2734:6: (enumLiteral_3= 'VALUE' )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2734:8: enumLiteral_3= 'VALUE'
                    {
                    enumLiteral_3=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleVariableCharacterisationType6032); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVariableCharacterisationTypeAccess().getVALUEEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getVariableCharacterisationTypeAccess().getVALUEEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2740:6: (enumLiteral_4= 'STRUCTURE' )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2740:6: (enumLiteral_4= 'STRUCTURE' )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2740:8: enumLiteral_4= 'STRUCTURE'
                    {
                    enumLiteral_4=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleVariableCharacterisationType6049); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVariableCharacterisationTypeAccess().getSTRUCTUREEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getVariableCharacterisationTypeAccess().getSTRUCTUREEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableCharacterisationType"


    // $ANTLR start "ruleBooleanOperations"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2750:1: ruleBooleanOperations returns [Enumerator current=null] : ( (enumLiteral_0= 'AND' ) | (enumLiteral_1= 'OR' ) | (enumLiteral_2= 'XOR' ) ) ;
    public final Enumerator ruleBooleanOperations() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2752:28: ( ( (enumLiteral_0= 'AND' ) | (enumLiteral_1= 'OR' ) | (enumLiteral_2= 'XOR' ) ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2753:1: ( (enumLiteral_0= 'AND' ) | (enumLiteral_1= 'OR' ) | (enumLiteral_2= 'XOR' ) )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2753:1: ( (enumLiteral_0= 'AND' ) | (enumLiteral_1= 'OR' ) | (enumLiteral_2= 'XOR' ) )
            int alt36=3;
            switch ( input.LA(1) ) {
            case 39:
                {
                alt36=1;
                }
                break;
            case 40:
                {
                alt36=2;
                }
                break;
            case 41:
                {
                alt36=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2753:2: (enumLiteral_0= 'AND' )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2753:2: (enumLiteral_0= 'AND' )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2753:4: enumLiteral_0= 'AND'
                    {
                    enumLiteral_0=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleBooleanOperations6094); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getBooleanOperationsAccess().getANDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getBooleanOperationsAccess().getANDEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2759:6: (enumLiteral_1= 'OR' )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2759:6: (enumLiteral_1= 'OR' )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2759:8: enumLiteral_1= 'OR'
                    {
                    enumLiteral_1=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleBooleanOperations6111); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getBooleanOperationsAccess().getOREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getBooleanOperationsAccess().getOREnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2765:6: (enumLiteral_2= 'XOR' )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2765:6: (enumLiteral_2= 'XOR' )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2765:8: enumLiteral_2= 'XOR'
                    {
                    enumLiteral_2=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleBooleanOperations6128); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getBooleanOperationsAccess().getXOREnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getBooleanOperationsAccess().getXOREnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanOperations"


    // $ANTLR start "ruleandoperation"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2775:1: ruleandoperation returns [Enumerator current=null] : (enumLiteral_0= 'AND' ) ;
    public final Enumerator ruleandoperation() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;

         enterRule(); 
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2777:28: ( (enumLiteral_0= 'AND' ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2778:1: (enumLiteral_0= 'AND' )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2778:1: (enumLiteral_0= 'AND' )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2778:3: enumLiteral_0= 'AND'
            {
            enumLiteral_0=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleandoperation6172); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = grammarAccess.getAndoperationAccess().getANDEnumLiteralDeclaration().getEnumLiteral().getInstance();
                      newLeafNode(enumLiteral_0, grammarAccess.getAndoperationAccess().getANDEnumLiteralDeclaration()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleandoperation"


    // $ANTLR start "ruleoroperations"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2788:1: ruleoroperations returns [Enumerator current=null] : ( (enumLiteral_0= 'OR' ) | (enumLiteral_1= 'XOR' ) ) ;
    public final Enumerator ruleoroperations() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2790:28: ( ( (enumLiteral_0= 'OR' ) | (enumLiteral_1= 'XOR' ) ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2791:1: ( (enumLiteral_0= 'OR' ) | (enumLiteral_1= 'XOR' ) )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2791:1: ( (enumLiteral_0= 'OR' ) | (enumLiteral_1= 'XOR' ) )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==40) ) {
                alt37=1;
            }
            else if ( (LA37_0==41) ) {
                alt37=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2791:2: (enumLiteral_0= 'OR' )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2791:2: (enumLiteral_0= 'OR' )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2791:4: enumLiteral_0= 'OR'
                    {
                    enumLiteral_0=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleoroperations6216); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getOroperationsAccess().getOREnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getOroperationsAccess().getOREnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2797:6: (enumLiteral_1= 'XOR' )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2797:6: (enumLiteral_1= 'XOR' )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2797:8: enumLiteral_1= 'XOR'
                    {
                    enumLiteral_1=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleoroperations6233); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getOroperationsAccess().getXOREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getOroperationsAccess().getXOREnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleoroperations"


    // $ANTLR start "ruleCompareOperations"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2807:1: ruleCompareOperations returns [Enumerator current=null] : ( (enumLiteral_0= '>' ) | (enumLiteral_1= '<' ) | (enumLiteral_2= '==' ) | (enumLiteral_3= '<>' ) | (enumLiteral_4= '>=' ) | (enumLiteral_5= '<=' ) ) ;
    public final Enumerator ruleCompareOperations() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;

         enterRule(); 
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2809:28: ( ( (enumLiteral_0= '>' ) | (enumLiteral_1= '<' ) | (enumLiteral_2= '==' ) | (enumLiteral_3= '<>' ) | (enumLiteral_4= '>=' ) | (enumLiteral_5= '<=' ) ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2810:1: ( (enumLiteral_0= '>' ) | (enumLiteral_1= '<' ) | (enumLiteral_2= '==' ) | (enumLiteral_3= '<>' ) | (enumLiteral_4= '>=' ) | (enumLiteral_5= '<=' ) )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2810:1: ( (enumLiteral_0= '>' ) | (enumLiteral_1= '<' ) | (enumLiteral_2= '==' ) | (enumLiteral_3= '<>' ) | (enumLiteral_4= '>=' ) | (enumLiteral_5= '<=' ) )
            int alt38=6;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt38=1;
                }
                break;
            case 43:
                {
                alt38=2;
                }
                break;
            case 44:
                {
                alt38=3;
                }
                break;
            case 45:
                {
                alt38=4;
                }
                break;
            case 46:
                {
                alt38=5;
                }
                break;
            case 47:
                {
                alt38=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2810:2: (enumLiteral_0= '>' )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2810:2: (enumLiteral_0= '>' )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2810:4: enumLiteral_0= '>'
                    {
                    enumLiteral_0=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleCompareOperations6278); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCompareOperationsAccess().getGREATEREnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getCompareOperationsAccess().getGREATEREnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2816:6: (enumLiteral_1= '<' )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2816:6: (enumLiteral_1= '<' )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2816:8: enumLiteral_1= '<'
                    {
                    enumLiteral_1=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleCompareOperations6295); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCompareOperationsAccess().getLESSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getCompareOperationsAccess().getLESSEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2822:6: (enumLiteral_2= '==' )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2822:6: (enumLiteral_2= '==' )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2822:8: enumLiteral_2= '=='
                    {
                    enumLiteral_2=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleCompareOperations6312); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCompareOperationsAccess().getEQUALSEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getCompareOperationsAccess().getEQUALSEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2828:6: (enumLiteral_3= '<>' )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2828:6: (enumLiteral_3= '<>' )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2828:8: enumLiteral_3= '<>'
                    {
                    enumLiteral_3=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleCompareOperations6329); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCompareOperationsAccess().getNOTEQUALEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getCompareOperationsAccess().getNOTEQUALEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2834:6: (enumLiteral_4= '>=' )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2834:6: (enumLiteral_4= '>=' )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2834:8: enumLiteral_4= '>='
                    {
                    enumLiteral_4=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleCompareOperations6346); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCompareOperationsAccess().getGREATEREQUALEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getCompareOperationsAccess().getGREATEREQUALEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2840:6: (enumLiteral_5= '<=' )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2840:6: (enumLiteral_5= '<=' )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2840:8: enumLiteral_5= '<='
                    {
                    enumLiteral_5=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleCompareOperations6363); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCompareOperationsAccess().getLESSEQUALEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getCompareOperationsAccess().getLESSEQUALEnumLiteralDeclaration_5()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCompareOperations"


    // $ANTLR start "ruleTermOperations"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2850:1: ruleTermOperations returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleTermOperations() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2852:28: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2853:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2853:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==48) ) {
                alt39=1;
            }
            else if ( (LA39_0==31) ) {
                alt39=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2853:2: (enumLiteral_0= '+' )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2853:2: (enumLiteral_0= '+' )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2853:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleTermOperations6408); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getTermOperationsAccess().getADDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getTermOperationsAccess().getADDEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2859:6: (enumLiteral_1= '-' )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2859:6: (enumLiteral_1= '-' )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2859:8: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleTermOperations6425); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getTermOperationsAccess().getSUBEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getTermOperationsAccess().getSUBEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTermOperations"


    // $ANTLR start "ruleProductOperations"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2869:1: ruleProductOperations returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) ;
    public final Enumerator ruleProductOperations() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2871:28: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2872:1: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2872:1: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            int alt40=3;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt40=1;
                }
                break;
            case 32:
                {
                alt40=2;
                }
                break;
            case 49:
                {
                alt40=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2872:2: (enumLiteral_0= '*' )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2872:2: (enumLiteral_0= '*' )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2872:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleProductOperations6470); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getProductOperationsAccess().getMULTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getProductOperationsAccess().getMULTEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2878:6: (enumLiteral_1= '/' )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2878:6: (enumLiteral_1= '/' )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2878:8: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleProductOperations6487); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getProductOperationsAccess().getDIVEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getProductOperationsAccess().getDIVEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2884:6: (enumLiteral_2= '%' )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2884:6: (enumLiteral_2= '%' )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2884:8: enumLiteral_2= '%'
                    {
                    enumLiteral_2=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleProductOperations6504); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getProductOperationsAccess().getMODEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getProductOperationsAccess().getMODEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProductOperations"


    // $ANTLR start "ruleUnitNames"
    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2894:1: ruleUnitNames returns [Enumerator current=null] : ( (enumLiteral_0= '_' ) | (enumLiteral_1= 'unitless' ) | (enumLiteral_2= 'B' ) | (enumLiteral_3= 's' ) | (enumLiteral_4= 'm' ) ) ;
    public final Enumerator ruleUnitNames() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;

         enterRule(); 
        try {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2896:28: ( ( (enumLiteral_0= '_' ) | (enumLiteral_1= 'unitless' ) | (enumLiteral_2= 'B' ) | (enumLiteral_3= 's' ) | (enumLiteral_4= 'm' ) ) )
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2897:1: ( (enumLiteral_0= '_' ) | (enumLiteral_1= 'unitless' ) | (enumLiteral_2= 'B' ) | (enumLiteral_3= 's' ) | (enumLiteral_4= 'm' ) )
            {
            // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2897:1: ( (enumLiteral_0= '_' ) | (enumLiteral_1= 'unitless' ) | (enumLiteral_2= 'B' ) | (enumLiteral_3= 's' ) | (enumLiteral_4= 'm' ) )
            int alt41=5;
            switch ( input.LA(1) ) {
            case 50:
                {
                alt41=1;
                }
                break;
            case 51:
                {
                alt41=2;
                }
                break;
            case 52:
                {
                alt41=3;
                }
                break;
            case 53:
                {
                alt41=4;
                }
                break;
            case 54:
                {
                alt41=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2897:2: (enumLiteral_0= '_' )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2897:2: (enumLiteral_0= '_' )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2897:4: enumLiteral_0= '_'
                    {
                    enumLiteral_0=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleUnitNames6549); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getUnitNamesAccess().getUNITLESSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getUnitNamesAccess().getUNITLESSEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2903:6: (enumLiteral_1= 'unitless' )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2903:6: (enumLiteral_1= 'unitless' )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2903:8: enumLiteral_1= 'unitless'
                    {
                    enumLiteral_1=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleUnitNames6566); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getUnitNamesAccess().getUNITLESSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getUnitNamesAccess().getUNITLESSEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2909:6: (enumLiteral_2= 'B' )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2909:6: (enumLiteral_2= 'B' )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2909:8: enumLiteral_2= 'B'
                    {
                    enumLiteral_2=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleUnitNames6583); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getUnitNamesAccess().getBYTEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getUnitNamesAccess().getBYTEEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2915:6: (enumLiteral_3= 's' )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2915:6: (enumLiteral_3= 's' )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2915:8: enumLiteral_3= 's'
                    {
                    enumLiteral_3=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleUnitNames6600); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getUnitNamesAccess().getSECONDEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getUnitNamesAccess().getSECONDEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2921:6: (enumLiteral_4= 'm' )
                    {
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2921:6: (enumLiteral_4= 'm' )
                    // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:2921:8: enumLiteral_4= 'm'
                    {
                    enumLiteral_4=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleUnitNames6617); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getUnitNamesAccess().getMETEREnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getUnitNamesAccess().getMETEREnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnitNames"

    // $ANTLR start synpred22_InternalPCMStoEx
    public final void synpred22_InternalPCMStoEx_fragment() throws RecognitionException {   
        EObject this_unitMulti_0 = null;


        // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1586:2: (this_unitMulti_0= ruleunitMulti )
        // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1586:2: this_unitMulti_0= ruleunitMulti
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleunitMulti_in_synpred22_InternalPCMStoEx3453);
        this_unitMulti_0=ruleunitMulti();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred22_InternalPCMStoEx

    // $ANTLR start synpred23_InternalPCMStoEx
    public final void synpred23_InternalPCMStoEx_fragment() throws RecognitionException {   
        EObject this_unitDiv_1 = null;


        // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1599:2: (this_unitDiv_1= ruleunitDiv )
        // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1599:2: this_unitDiv_1= ruleunitDiv
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleunitDiv_in_synpred23_InternalPCMStoEx3483);
        this_unitDiv_1=ruleunitDiv();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred23_InternalPCMStoEx

    // $ANTLR start synpred25_InternalPCMStoEx
    public final void synpred25_InternalPCMStoEx_fragment() throws RecognitionException {   
        Token otherlv_2=null;
        EObject lv_units_3_0 = null;


        // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1720:2: ( () otherlv_2= '*' ( (lv_units_3_0= ruleUnit ) ) )
        // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1720:2: () otherlv_2= '*' ( (lv_units_3_0= ruleUnit ) )
        {
        // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1720:2: ()
        // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1721:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        otherlv_2=(Token)match(input,33,FollowSets000.FOLLOW_33_in_synpred25_InternalPCMStoEx3775); if (state.failed) return ;
        // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1733:1: ( (lv_units_3_0= ruleUnit ) )
        // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1734:1: (lv_units_3_0= ruleUnit )
        {
        // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1734:1: (lv_units_3_0= ruleUnit )
        // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1735:3: lv_units_3_0= ruleUnit
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getUnitMultiAccess().getUnitsUnitParserRuleCall_1_2_0()); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_ruleUnit_in_synpred25_InternalPCMStoEx3796);
        lv_units_3_0=ruleUnit();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred25_InternalPCMStoEx

    // $ANTLR start synpred27_InternalPCMStoEx
    public final void synpred27_InternalPCMStoEx_fragment() throws RecognitionException {   
        EObject this_unitMulti_2 = null;


        // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1790:2: (this_unitMulti_2= ruleunitMulti )
        // ../de.uka.ipd.sdq.pcm/src-gen/org/palladiosimulator/pcm/pcmstoex/parser/antlr/internal/InternalPCMStoEx.g:1790:2: this_unitMulti_2= ruleunitMulti
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleunitMulti_in_synpred27_InternalPCMStoEx3937);
        this_unitMulti_2=ruleunitMulti();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred27_InternalPCMStoEx

    // Delegated rules

    public final boolean synpred25_InternalPCMStoEx() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred25_InternalPCMStoEx_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_InternalPCMStoEx() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_InternalPCMStoEx_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred23_InternalPCMStoEx() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_InternalPCMStoEx_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_InternalPCMStoEx() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_InternalPCMStoEx_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA9 dfa9 = new DFA9(this);
    protected DFA15 dfa15 = new DFA15(this);
    static final String DFA9_eotS =
        "\12\uffff";
    static final String DFA9_eofS =
        "\12\uffff";
    static final String DFA9_minS =
        "\1\11\4\uffff\1\4\4\uffff";
    static final String DFA9_maxS =
        "\1\30\4\uffff\1\14\4\uffff";
    static final String DFA9_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\uffff\1\7\1\10\1\6\1\5";
    static final String DFA9_specialS =
        "\12\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\2\2\uffff\1\6\1\uffff\1\5\1\uffff\1\4\1\3\1\1\4\7\1\uffff"+
            "\1\7",
            "",
            "",
            "",
            "",
            "\1\10\7\uffff\1\11",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "934:1: (this_IntLiteral_0= ruleIntLiteral | this_DoubleLiteral_1= ruleDoubleLiteral | this_StringLiteral_2= ruleStringLiteral | this_BoolLiteral_3= ruleBoolLiteral | this_FunctionLiteral_4= ruleFunctionLiteral | this_Variable_5= ruleVariable | this_Parenthesis_6= ruleParenthesis | this_ProbabilityFunctionLiteral_7= ruleProbabilityFunctionLiteral )";
        }
    }
    static final String DFA15_eotS =
        "\12\uffff";
    static final String DFA15_eofS =
        "\12\uffff";
    static final String DFA15_minS =
        "\1\14\6\0\3\uffff";
    static final String DFA15_maxS =
        "\1\66\6\0\3\uffff";
    static final String DFA15_acceptS =
        "\7\uffff\1\1\1\2\1\3";
    static final String DFA15_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\3\uffff}>";
    static final String[] DFA15_transitionS = {
            "\1\6\45\uffff\1\1\1\2\1\3\1\4\1\5",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            ""
    };

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "1585:1: (this_unitMulti_0= ruleunitMulti | this_unitDiv_1= ruleunitDiv | this_BaseUnit_2= ruleBaseUnit )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA15_1 = input.LA(1);

                         
                        int index15_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalPCMStoEx()) ) {s = 7;}

                        else if ( (synpred23_InternalPCMStoEx()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index15_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA15_2 = input.LA(1);

                         
                        int index15_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalPCMStoEx()) ) {s = 7;}

                        else if ( (synpred23_InternalPCMStoEx()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index15_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA15_3 = input.LA(1);

                         
                        int index15_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalPCMStoEx()) ) {s = 7;}

                        else if ( (synpred23_InternalPCMStoEx()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index15_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA15_4 = input.LA(1);

                         
                        int index15_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalPCMStoEx()) ) {s = 7;}

                        else if ( (synpred23_InternalPCMStoEx()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index15_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA15_5 = input.LA(1);

                         
                        int index15_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalPCMStoEx()) ) {s = 7;}

                        else if ( (synpred23_InternalPCMStoEx()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index15_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA15_6 = input.LA(1);

                         
                        int index15_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalPCMStoEx()) ) {s = 7;}

                        else if ( (synpred23_InternalPCMStoEx()) ) {s = 8;}

                         
                        input.seek(index15_6);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 15, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleausdruck_in_entryRuleausdruck81 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleausdruck91 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleexpression_in_ruleausdruck140 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariable_in_entryRuleVariable174 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVariable184 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCharacterisedVariable_in_ruleVariable233 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCharacterisedVariable_in_entryRuleCharacterisedVariable267 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCharacterisedVariable277 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariableReference_in_ruleCharacterisedVariable323 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_DOT_in_ruleCharacterisedVariable334 = new BitSet(new long[]{0x0000007C00000000L});
        public static final BitSet FOLLOW_ruleVariableCharacterisationType_in_ruleCharacterisedVariable354 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleexpression_in_entryRuleexpression390 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleexpression400 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleifelseExpr_in_ruleexpression449 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleifelseExpr_in_entryRuleifelseExpr483 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleifelseExpr493 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleboolAndExpr_in_ruleifelseExpr543 = new BitSet(new long[]{0x0000000000000022L});
        public static final BitSet FOLLOW_RULE_CONDDELIMITER_in_ruleifelseExpr566 = new BitSet(new long[]{0x00000000817F5300L});
        public static final BitSet FOLLOW_ruleboolAndExpr_in_ruleifelseExpr586 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_ELSEDELIMITER_in_ruleifelseExpr597 = new BitSet(new long[]{0x00000000817F5300L});
        public static final BitSet FOLLOW_ruleboolAndExpr_in_ruleifelseExpr617 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleboolAndExpr_in_entryRuleboolAndExpr657 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleboolAndExpr667 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleboolOrExpr_in_ruleboolAndExpr717 = new BitSet(new long[]{0x0000008000000002L});
        public static final BitSet FOLLOW_ruleandoperation_in_ruleboolAndExpr750 = new BitSet(new long[]{0x00000000817F5300L});
        public static final BitSet FOLLOW_ruleboolOrExpr_in_ruleboolAndExpr771 = new BitSet(new long[]{0x0000008000000002L});
        public static final BitSet FOLLOW_ruleboolOrExpr_in_entryRuleboolOrExpr809 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleboolOrExpr819 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulecompareExpr_in_ruleboolOrExpr869 = new BitSet(new long[]{0x0000030000000002L});
        public static final BitSet FOLLOW_ruleoroperations_in_ruleboolOrExpr902 = new BitSet(new long[]{0x00000000817F5300L});
        public static final BitSet FOLLOW_rulecompareExpr_in_ruleboolOrExpr923 = new BitSet(new long[]{0x0000030000000002L});
        public static final BitSet FOLLOW_rulecompareExpr_in_entryRulecompareExpr961 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulecompareExpr971 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulesumExpr_in_rulecompareExpr1021 = new BitSet(new long[]{0x0000FC0000000002L});
        public static final BitSet FOLLOW_ruleCompareOperations_in_rulecompareExpr1054 = new BitSet(new long[]{0x00000000817F5300L});
        public static final BitSet FOLLOW_rulesumExpr_in_rulecompareExpr1075 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulesumExpr_in_entryRulesumExpr1113 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulesumExpr1123 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleprodExpr_in_rulesumExpr1173 = new BitSet(new long[]{0x0001000080000002L});
        public static final BitSet FOLLOW_ruleTermOperations_in_rulesumExpr1206 = new BitSet(new long[]{0x00000000817F5300L});
        public static final BitSet FOLLOW_ruleprodExpr_in_rulesumExpr1227 = new BitSet(new long[]{0x0001000080000002L});
        public static final BitSet FOLLOW_ruleprodExpr_in_entryRuleprodExpr1265 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleprodExpr1275 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulepowExpr_in_ruleprodExpr1325 = new BitSet(new long[]{0x0002000300000002L});
        public static final BitSet FOLLOW_ruleProductOperations_in_ruleprodExpr1358 = new BitSet(new long[]{0x00000000817F5300L});
        public static final BitSet FOLLOW_rulepowExpr_in_ruleprodExpr1379 = new BitSet(new long[]{0x0002000300000002L});
        public static final BitSet FOLLOW_rulepowExpr_in_entryRulepowExpr1417 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulepowExpr1427 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleunaryExpr_in_rulepowExpr1477 = new BitSet(new long[]{0x0000000000000082L});
        public static final BitSet FOLLOW_RULE_POW_in_rulepowExpr1500 = new BitSet(new long[]{0x00000000817F5300L});
        public static final BitSet FOLLOW_ruleunaryExpr_in_rulepowExpr1520 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleunaryExpr_in_entryRuleunaryExpr1558 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleunaryExpr1568 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNegativeExpression_in_ruleunaryExpr1618 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNotExpression_in_ruleunaryExpr1648 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleatom_in_ruleunaryExpr1678 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNotExpression_in_entryRuleNotExpression1713 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNotExpression1723 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_NOT_in_ruleNotExpression1759 = new BitSet(new long[]{0x00000000817F5300L});
        public static final BitSet FOLLOW_ruleunaryExpr_in_ruleNotExpression1779 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNegativeExpression_in_entryRuleNegativeExpression1815 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNegativeExpression1825 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleNegativeExpression1862 = new BitSet(new long[]{0x00000000817F5300L});
        public static final BitSet FOLLOW_ruleunaryExpr_in_ruleNegativeExpression1883 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleatom_in_entryRuleatom1919 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleatom1929 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIntLiteral_in_ruleatom1979 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDoubleLiteral_in_ruleatom2009 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteral_in_ruleatom2039 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBoolLiteral_in_ruleatom2069 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFunctionLiteral_in_ruleatom2099 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariable_in_ruleatom2129 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesis_in_ruleatom2159 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProbabilityFunctionLiteral_in_ruleatom2189 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDoubleLiteral_in_entryRuleDoubleLiteral2224 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDoubleLiteral2234 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_DOUBLE_in_ruleDoubleLiteral2276 = new BitSet(new long[]{0x0000000000000402L});
        public static final BitSet FOLLOW_RULE_SQUARE_PAREN_L_in_ruleDoubleLiteral2293 = new BitSet(new long[]{0x007C000000001000L});
        public static final BitSet FOLLOW_ruleUnit_in_ruleDoubleLiteral2313 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_RULE_SQUARE_PAREN_R_in_ruleDoubleLiteral2324 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProbabilityFunctionLiteral_in_entryRuleProbabilityFunctionLiteral2361 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleProbabilityFunctionLiteral2371 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruledefinition_in_ruleProbabilityFunctionLiteral2416 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesis_in_entryRuleParenthesis2451 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParenthesis2461 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LPAREN_in_ruleParenthesis2497 = new BitSet(new long[]{0x00000000817F5300L});
        public static final BitSet FOLLOW_ruleifelseExpr_in_ruleParenthesis2517 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_RULE_RPAREN_in_ruleParenthesis2528 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFunctionLiteral_in_entryRuleFunctionLiteral2563 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFunctionLiteral2573 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFunctionLiteral2615 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_RULE_LPAREN_in_ruleFunctionLiteral2631 = new BitSet(new long[]{0x00000000817F7300L});
        public static final BitSet FOLLOW_ruleboolAndExpr_in_ruleFunctionLiteral2652 = new BitSet(new long[]{0x000000000000A000L});
        public static final BitSet FOLLOW_RULE_COLON_in_ruleFunctionLiteral2664 = new BitSet(new long[]{0x00000000817F5300L});
        public static final BitSet FOLLOW_ruleboolAndExpr_in_ruleFunctionLiteral2684 = new BitSet(new long[]{0x000000000000A000L});
        public static final BitSet FOLLOW_RULE_RPAREN_in_ruleFunctionLiteral2699 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractNamedReference_in_entryRuleAbstractNamedReference2734 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractNamedReference2744 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariableReference_in_ruleAbstractNamedReference2794 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNamespaceReference_in_ruleAbstractNamedReference2824 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariableReference_in_entryRuleVariableReference2859 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVariableReference2869 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleVariableReference2910 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNamespaceReference_in_entryRuleNamespaceReference2950 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNamespaceReference2960 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNamespaceReference3002 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_DOT_in_ruleNamespaceReference3018 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_ruleAbstractNamedReference_in_ruleNamespaceReference3038 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBoolLiteral_in_entryRuleBoolLiteral3074 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBoolLiteral3084 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_BOOLEAN_KEYWORDS_in_ruleBoolLiteral3125 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral3165 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral3175 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleStringLiteral3216 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral3256 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIntLiteral3266 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_DECINT_in_ruleIntLiteral3308 = new BitSet(new long[]{0x0000000000000402L});
        public static final BitSet FOLLOW_RULE_SQUARE_PAREN_L_in_ruleIntLiteral3325 = new BitSet(new long[]{0x007C000000001000L});
        public static final BitSet FOLLOW_ruleUnit_in_ruleIntLiteral3345 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_RULE_SQUARE_PAREN_R_in_ruleIntLiteral3356 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnit_in_entryRuleUnit3393 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnit3403 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleunitMulti_in_ruleUnit3453 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleunitDiv_in_ruleUnit3483 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBaseUnit_in_ruleUnit3513 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleunitDiv_in_entryRuleunitDiv3548 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleunitDiv3558 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleunitPow_in_ruleunitDiv3608 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_32_in_ruleunitDiv3632 = new BitSet(new long[]{0x007C000000001000L});
        public static final BitSet FOLLOW_ruleUnit_in_ruleunitDiv3653 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleunitMulti_in_entryRuleunitMulti3691 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleunitMulti3701 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleunitPow_in_ruleunitMulti3751 = new BitSet(new long[]{0x0000000200000002L});
        public static final BitSet FOLLOW_33_in_ruleunitMulti3775 = new BitSet(new long[]{0x007C000000001000L});
        public static final BitSet FOLLOW_ruleUnit_in_ruleunitMulti3796 = new BitSet(new long[]{0x0000000200000002L});
        public static final BitSet FOLLOW_ruleunitPow_in_entryRuleunitPow3834 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleunitPow3844 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBaseUnit_in_ruleunitPow3895 = new BitSet(new long[]{0x0000000000000082L});
        public static final BitSet FOLLOW_RULE_LPAREN_in_ruleunitPow3912 = new BitSet(new long[]{0x007C000000001000L});
        public static final BitSet FOLLOW_ruleunitMulti_in_ruleunitPow3937 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_ruleunitDiv_in_ruleunitPow3967 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_RULE_RPAREN_in_ruleunitPow3978 = new BitSet(new long[]{0x0000000000000082L});
        public static final BitSet FOLLOW_RULE_POW_in_ruleunitPow4003 = new BitSet(new long[]{0x0000000080040000L});
        public static final BitSet FOLLOW_ruleSIGNED_INT_in_ruleunitPow4023 = new BitSet(new long[]{0x0000000000000082L});
        public static final BitSet FOLLOW_ruleBaseUnit_in_entryRuleBaseUnit4061 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBaseUnit4071 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnitNames_in_ruleBaseUnit4116 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruledefinition_in_entryRuledefinition4151 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuledefinition4161 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProbabilityMassFunction_in_ruledefinition4211 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProbabilityDensityFunction_in_ruledefinition4241 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProbabilityDensityFunction_in_entryRuleProbabilityDensityFunction4276 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleProbabilityDensityFunction4286 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBoxedPDF_in_ruleProbabilityDensityFunction4335 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBoxedPDF_in_entryRuleBoxedPDF4369 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBoxedPDF4379 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_DOUBLEPDF_in_ruleBoxedPDF4415 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_RULE_SQUARE_PAREN_L_in_ruleBoxedPDF4425 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_rulereal_pdf_sample_in_ruleBoxedPDF4445 = new BitSet(new long[]{0x0000000000001800L});
        public static final BitSet FOLLOW_RULE_SQUARE_PAREN_R_in_ruleBoxedPDF4457 = new BitSet(new long[]{0x0000000000000402L});
        public static final BitSet FOLLOW_RULE_SQUARE_PAREN_L_in_ruleBoxedPDF4468 = new BitSet(new long[]{0x007C000000001000L});
        public static final BitSet FOLLOW_ruleUnit_in_ruleBoxedPDF4488 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_RULE_SQUARE_PAREN_R_in_ruleBoxedPDF4499 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProbabilityMassFunction_in_entryRuleProbabilityMassFunction4536 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleProbabilityMassFunction4546 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INTPMF_in_ruleProbabilityMassFunction4583 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_RULE_SQUARE_PAREN_L_in_ruleProbabilityMassFunction4593 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_rulenumeric_int_sample_in_ruleProbabilityMassFunction4613 = new BitSet(new long[]{0x0000000000001800L});
        public static final BitSet FOLLOW_RULE_SQUARE_PAREN_R_in_ruleProbabilityMassFunction4625 = new BitSet(new long[]{0x0000000000000402L});
        public static final BitSet FOLLOW_RULE_SQUARE_PAREN_L_in_ruleProbabilityMassFunction4636 = new BitSet(new long[]{0x007C000000001000L});
        public static final BitSet FOLLOW_ruleUnit_in_ruleProbabilityMassFunction4656 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_RULE_SQUARE_PAREN_R_in_ruleProbabilityMassFunction4667 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_DOUBLEPMF_in_ruleProbabilityMassFunction4687 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_RULE_SQUARE_PAREN_L_in_ruleProbabilityMassFunction4697 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_rulenumeric_real_sample_in_ruleProbabilityMassFunction4717 = new BitSet(new long[]{0x0000000000001800L});
        public static final BitSet FOLLOW_RULE_SQUARE_PAREN_R_in_ruleProbabilityMassFunction4729 = new BitSet(new long[]{0x0000000000000402L});
        public static final BitSet FOLLOW_RULE_SQUARE_PAREN_L_in_ruleProbabilityMassFunction4740 = new BitSet(new long[]{0x007C000000001000L});
        public static final BitSet FOLLOW_ruleUnit_in_ruleProbabilityMassFunction4760 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_RULE_SQUARE_PAREN_R_in_ruleProbabilityMassFunction4771 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ENUMPMF_in_ruleProbabilityMassFunction4791 = new BitSet(new long[]{0x0000000000001400L});
        public static final BitSet FOLLOW_RULE_LPAREN_in_ruleProbabilityMassFunction4802 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_RULE_ORDERED_DEF_in_ruleProbabilityMassFunction4818 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_RULE_RPAREN_in_ruleProbabilityMassFunction4834 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_RULE_SQUARE_PAREN_L_in_ruleProbabilityMassFunction4846 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_rulestringsample_in_ruleProbabilityMassFunction4866 = new BitSet(new long[]{0x0000000000001800L});
        public static final BitSet FOLLOW_RULE_SQUARE_PAREN_R_in_ruleProbabilityMassFunction4878 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_BOOLPMF_in_ruleProbabilityMassFunction4896 = new BitSet(new long[]{0x0000000000001400L});
        public static final BitSet FOLLOW_RULE_LPAREN_in_ruleProbabilityMassFunction4907 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_RULE_ORDERED_DEF_in_ruleProbabilityMassFunction4923 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_RULE_RPAREN_in_ruleProbabilityMassFunction4939 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_RULE_SQUARE_PAREN_L_in_ruleProbabilityMassFunction4951 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_ruleboolsample_in_ruleProbabilityMassFunction4971 = new BitSet(new long[]{0x0000000000001800L});
        public static final BitSet FOLLOW_RULE_SQUARE_PAREN_R_in_ruleProbabilityMassFunction4983 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulenumeric_int_sample_in_entryRulenumeric_int_sample5019 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulenumeric_int_sample5029 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LPAREN_in_rulenumeric_int_sample5065 = new BitSet(new long[]{0x0000000080040000L});
        public static final BitSet FOLLOW_ruleSIGNED_INT_in_rulenumeric_int_sample5085 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_RULE_SEMI_in_rulenumeric_int_sample5096 = new BitSet(new long[]{0x0000000000000200L});
        public static final BitSet FOLLOW_RULE_DOUBLE_in_rulenumeric_int_sample5112 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_RULE_RPAREN_in_rulenumeric_int_sample5128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulenumeric_real_sample_in_entryRulenumeric_real_sample5163 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulenumeric_real_sample5173 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LPAREN_in_rulenumeric_real_sample5209 = new BitSet(new long[]{0x0000000080000200L});
        public static final BitSet FOLLOW_ruleSIGNED_NUMBER_in_rulenumeric_real_sample5229 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_RULE_SEMI_in_rulenumeric_real_sample5240 = new BitSet(new long[]{0x0000000000000200L});
        public static final BitSet FOLLOW_RULE_DOUBLE_in_rulenumeric_real_sample5256 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_RULE_RPAREN_in_rulenumeric_real_sample5272 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulereal_pdf_sample_in_entryRulereal_pdf_sample5307 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulereal_pdf_sample5317 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LPAREN_in_rulereal_pdf_sample5353 = new BitSet(new long[]{0x0000000080000200L});
        public static final BitSet FOLLOW_ruleSIGNED_NUMBER_in_rulereal_pdf_sample5373 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_RULE_SEMI_in_rulereal_pdf_sample5384 = new BitSet(new long[]{0x0000000000000200L});
        public static final BitSet FOLLOW_RULE_DOUBLE_in_rulereal_pdf_sample5400 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_RULE_RPAREN_in_rulereal_pdf_sample5416 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulestringsample_in_entryRulestringsample5451 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulestringsample5461 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LPAREN_in_rulestringsample5497 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_RULE_STRING_in_rulestringsample5513 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_RULE_SEMI_in_rulestringsample5529 = new BitSet(new long[]{0x0000000000000200L});
        public static final BitSet FOLLOW_RULE_DOUBLE_in_rulestringsample5545 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_RULE_RPAREN_in_rulestringsample5561 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleboolsample_in_entryRuleboolsample5596 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleboolsample5606 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LPAREN_in_ruleboolsample5642 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_RULE_BOOLEAN_KEYWORDS_in_ruleboolsample5658 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_RULE_SEMI_in_ruleboolsample5674 = new BitSet(new long[]{0x0000000000000200L});
        public static final BitSet FOLLOW_RULE_DOUBLE_in_ruleboolsample5690 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_RULE_RPAREN_in_ruleboolsample5706 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSIGNED_NUMBER_in_entryRuleSIGNED_NUMBER5742 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSIGNED_NUMBER5753 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleSIGNED_NUMBER5792 = new BitSet(new long[]{0x0000000000000200L});
        public static final BitSet FOLLOW_RULE_DOUBLE_in_ruleSIGNED_NUMBER5809 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSIGNED_INT_in_entryRuleSIGNED_INT5855 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSIGNED_INT5866 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleSIGNED_INT5905 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_RULE_DECINT_in_ruleSIGNED_INT5922 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleVariableCharacterisationType5981 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleVariableCharacterisationType5998 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleVariableCharacterisationType6015 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleVariableCharacterisationType6032 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleVariableCharacterisationType6049 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleBooleanOperations6094 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleBooleanOperations6111 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleBooleanOperations6128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleandoperation6172 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleoroperations6216 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleoroperations6233 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleCompareOperations6278 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_ruleCompareOperations6295 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_ruleCompareOperations6312 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_ruleCompareOperations6329 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_ruleCompareOperations6346 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_47_in_ruleCompareOperations6363 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_48_in_ruleTermOperations6408 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleTermOperations6425 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleProductOperations6470 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleProductOperations6487 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_49_in_ruleProductOperations6504 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_ruleUnitNames6549 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_ruleUnitNames6566 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_ruleUnitNames6583 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_ruleUnitNames6600 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_ruleUnitNames6617 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleunitMulti_in_synpred22_InternalPCMStoEx3453 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleunitDiv_in_synpred23_InternalPCMStoEx3483 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_synpred25_InternalPCMStoEx3775 = new BitSet(new long[]{0x007C000000001000L});
        public static final BitSet FOLLOW_ruleUnit_in_synpred25_InternalPCMStoEx3796 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleunitMulti_in_synpred27_InternalPCMStoEx3937 = new BitSet(new long[]{0x0000000000000002L});
    }


}