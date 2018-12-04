/*
 * This file is part of GumTree.
 *
 * GumTree is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * GumTree is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with GumTree.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright 2011-2015 Jean-Rémy Falleri <jr.falleri@gmail.com>
 * Copyright 2011-2015 Floréal Morandat <florealm@gmail.com>
 */

package com.github.gumtreediff.gen.antlr3.liquid;

import com.github.gumtreediff.gen.antlr3.AbstractAntlr3TreeGenerator;
import com.github.gumtreediff.gen.Register;
import org.antlr.runtime.*;

import liqp.parser.LiquidParser;
import liqp.parser.LiquidLexer;

@Register(id = "liquid-antlr", accept = "\\.liquid.?$")
public class LiquidTreeGenerator extends AbstractAntlr3TreeGenerator<LiquidLexer, LiquidParser> {

    @Override
    protected LiquidLexer getLexer(ANTLRStringStream stream) {
        return new LiquidLexer(stream);
    }

    @Override
    protected LiquidParser getParser(TokenStream tokens) {
        return new LiquidParser(tokens);
    }

    @Override
    protected RuleReturnScope getStartRule(LiquidParser parser) throws RecognitionException {
        return parser.block();
    }

    @Override
    protected final String[] getTokenNames() {
        return LiquidParser.tokenNames;
    }
}